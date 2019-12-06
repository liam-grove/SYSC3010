#rpi-arduino-dht11
import serial, socket, string, sys, time #, pymysql
from timeloop import Timeloop
from datetime import timedelta

serverIP = "172.20.10.3"
serverPort = 56789


#try:
 #   conn = pymysql.connect(host = '172.17.55.14',
  #                         user='natalie',
   #                        passwd='password',
    #                       db='greenhouse',
     #                      charset='utf8mb4',
      #                     cursorclass=pymysql.cursors.DictCursor)
    # Create a Cursor object to execute queries.
  #  cur = conn.cursor()

#except Exception as e:
 #   print("Exeception occured:{}".format(e))

sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
clientport = 56789
serverAddress = (serverIP, serverPort)
arduino = serial.Serial('/dev/ttyACM1', 9600)
#sock.bind((serverIP, serverPort))

wateringActive = 10 #time between turning water on/off
wateringInterval = 25 #time between watering cycles

bootMessage = "dpi:ser:BOOT:test"
sock.sendto(bootMessage.encode('utf-8'), (serverIP, serverPort))
print("Boot message sent")

tl = Timeloop()

@tl.job(interval=timedelta(seconds=3))
def transmit_data():
    
    if arduino.in_waiting > 0:
        rawMessage = arduino.readline()
        decodedMessage = rawMessage.decode('utf-8').strip('\r\n')
        splitMessage = decodedMessage.split(',')
        light = splitMessage[0].strip('<')
        temperature = splitMessage[1]
        humidity = splitMessage[2].strip('>')
                
         #queryTemplate = "INSERT INTO collected_data(Username, Date, Time, Temperature, Humidity, LightLevel) VALUES({},{},{},{},{},{})"
         #query = queryTemplate.format(username, date, time, temperature, humidity, light)
                
        #cur.execute(query)
         
        dataMessageTemplate = "<{},{},{}>"
        dataMessage = dataMessageTemplate.format(light, temperature, humidity)
                
        controlPiMessage = "dpi:cpi:data:" + dataMessage
        print(controlPiMessage)
        sock.sendto(controlPiMessage.encode('utf-8'), serverAddress)
        
@tl.job(interval=timedelta(seconds=10))
def receive_data():
    
    data, addr = sock.recvfrom(1024)
    print("Data received:")
    print(data)
    
    data2 = data.decode()
    print("Decoded: ")
    print(data2)
    
    splitData = data2.split(':')
    print("Data: ")
    print(splitData[3])
    code = splitData[2]
    if code == "WATER1":
        wateringInterval = splitData[3]
        print("Watering interval set to: ")
        print(splitData[3])
    if code == "WATER2":
        wateringActive = splitData[3]
        print("Watering delay set to: ")
        print(splitData[3])
        
@tl.job(interval=timedelta(seconds=wateringInterval))
def activate_water():
    
    activate = "1"
    deactivate = "0"
    
    print("Activating motor")
    arduino.write(activate.encode('utf-8'))
    time.sleep(wateringActive)
    print("Deactivating motor")
    arduino.write(deactivate.encode('utf-8'))
    
if __name__ == "__main__":
    tl.start(block=True)
    
                    
            
sock.shutdown(1)
