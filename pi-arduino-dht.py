#rpi-arduino-dht11
#Raspberry Pi reads temperature and humidity sensor data from Arduino
import serial, socket, string, sys, time

serverHost = sys.argv[1]
serverPort = sys.argv[2]

sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
port = int(serverPort)
serverAddress = (serverHost, port)
ser = serial.Serial('/dev/ttyUSB0', 9600)

while True:
        if ser.in_waiting > 0:
            rawMessage = ser.readline()
            decodedMessage = rawMessage.decode('utf-8').strip('\r\n')
            splitMessage = decodedMessage.split(',')
            light = splitMessage[0].strip('<')
            temperature = splitMessage[1]
            humidity = splitMessage[2].strip('>')
            
            sock.sendto(decodedMessage.encode('utf-8'), serverAddress)
            
sock.shutdown(1)
            