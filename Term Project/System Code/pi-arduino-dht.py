#rpi-arduino-dht11
#Raspberry Pi reads temperature and humidity sensor data from Arduino
import serial, socket, string, sys, time
#, MySQLdb

serverIP = 172.17.61.82
serverPort = 9876

sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
clientport = 56789
serverAddress = (serverHost, port)
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
            
            dataMessageTemplate = "<{},{},{}>"
            dataMessage = dataMessageTemplate.format(light, temperature, humidity)
            
            controlPiMessage = "dpi:cpi:data:" + dataMessage
            #print(controlPiMessage)
            sock.sendto(controlPiMessage.encode('utf-8'), serverAddress)
            
        buf, address = sock.recvfrom(port)
        
        #receive incoming messages
        buf
        
        #check incoming message validity
        
        #send command to arduino
        
        #
        
            
            
sock.shutdown(1)
            
