#rpi-arduino-dht11
import serial, socket, string, sys, time, pymysql

serverIP = "172.17.61.82"
serverPort = 9876


try:
    conn = pymysql.connect(host = '172.17.55.14',
                           user='natalie',
                           passwd='password',
                           db='greenhouse',
                           charset='utf8mb4',
                           cursorclass=pymysql.cursors.DictCursor)
    # Create a Cursor object to execute queries.
    cur = conn.cursor()

except Exception as e:
    print("Exeception occured:{}".format(e))

sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
clientport = 56789
serverAddress = (serverIP, serverPort)
arduino = serial.Serial('/dev/ttyUSB0', 9600)
sock.bind(serverAddress)

wateringActive = 0 #time between turning water on/off
wateringInterval = 0 #time between watering cycles

while True:
        if arduino.in_waiting > 0:
            rawMessage = arduino.readline()
            decodedMessage = rawMessage.decode('utf-8').strip('\r\n')
            splitMessage = decodedMessage.split(',')
            light = splitMessage[0].strip('<')
            temperature = splitMessage[1]
            humidity = splitMessage[2].strip('>')
            
            queryTemplate = "INSERT INTO collected_data(Username, Date, Time, Temperature, Humidity, LightLevel) VALUES({},{},{},{},{},{})"
            query = queryTemplate.format(username, date, time, temperature, humidity, light)
            
            cur.execute(query)
            
            dataMessageTemplate = "<{},{},{}>"
            dataMessage = dataMessageTemplate.format(light, temperature, humidity)
            
            controlPiMessage = "dpi:cpi:data:" + dataMessage
            #print(controlPiMessage)
            sock.sendto(controlPiMessage.encode('utf-8'), serverAddress)
        
        #buf, address = sock.recvfrom(port)
        
        #receive incoming messages
        
        #check incoming message validity
        
        #send command to arduino
        
            
            
sock.shutdown(1)
