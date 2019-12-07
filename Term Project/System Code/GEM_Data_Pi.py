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

sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM) #create socket
clientport = 56789
serverAddress = (serverIP, serverPort)
arduino = serial.Serial('/dev/ttyACM1', 9600) #assign serial connection (this changes depending on the connection, sometimes ACM0)
#sock.bind((serverIP, serverPort))

wateringActive = 10 #time between turning water on/off
wateringInterval = 25 #time between watering cycles

bootMessage = "dpi:ser:BOOT:test"
sock.sendto(bootMessage.encode('utf-8'), (serverIP, serverPort)) #send initialization message
print("Boot message sent")

tl = Timeloop() #setup timeloop object

@tl.job(interval=timedelta(seconds=3)) #create periodic function that runs every 3 seconds
def transmit_data():
    
    if arduino.in_waiting > 0: #read in data from Arduino
        rawMessage = arduino.readline()
        decodedMessage = rawMessage.decode('utf-8').strip('\r\n')
        splitMessage = decodedMessage.split(',')
        light = splitMessage[0].strip('<')
        temperature = splitMessage[1]
        humidity = splitMessage[2].strip('>')
                
         #queryTemplate = "INSERT INTO collected_data(Username, Date, Time, Temperature, Humidity, LightLevel) VALUES({},{},{},{},{},{})"
         #query = queryTemplate.format(username, date, time, temperature, humidity, light)
                
        #cur.execute(query)
         
        dataMessageTemplate = "<{},{},{}>" #format data for transmission
        dataMessage = dataMessageTemplate.format(light, temperature, humidity)
                
        controlPiMessage = "dpi:cpi:data:" + dataMessage
        print(controlPiMessage)
        sock.sendto(controlPiMessage.encode('utf-8'), serverAddress) #send data to server
        
@tl.job(interval=timedelta(seconds=10)) #create periodic task with period of 10 seconds
def receive_data():
    
    data, addr = sock.recvfrom(1024) #receive data from server
    print("Data received:")
    print(data)
    
    data2 = data.decode() #decode received message
    print("Decoded: ")
    print(data2)
    
    splitData = data2.split(':') #split received message following standard protocol
    print("Data: ")
    print(splitData[3])
    code = splitData[2]
    if code == "WATER1":
        wateringInterval = splitData[3] #if case 1, change how often system waters
        print("Watering interval set to: ")
        print(splitData[3])
    if code == "WATER2":
        wateringActive = splitData[3] #if case 2, change how long it waters for
        print("Watering delay set to: ")
        print(splitData[3])
        
@tl.job(interval=timedelta(seconds=wateringInterval)) #create periodic task with period of a set value
def activate_water():
    
    activate = "1"
    deactivate = "0"
    
    print("Activating motor")
    arduino.write(activate.encode('utf-8')) #instruct Arduino to rotate motor clockwise
    time.sleep(wateringActive) #wait for set interval
    print("Deactivating motor")
    arduino.write(deactivate.encode('utf-8')) #instruct Arduino to rotate motor counterclockwise
    
if __name__ == "__main__":
    tl.start(block=True) #run all periodic tasks
    
                    
            
sock.shutdown(1)
