#rpi-arduino
#Raspberry Pi reads light sensor data from Arduino
import serial, socket, string, sys, time

ser = serial.Serial('/dev/ttyUSB0', 9600)

while True:
        if ser.in_waiting > 0:
            rawMessage = ser.readline()
            decodedMessage = rawMessage.decode('utf-8').strip('\r\n')
            strippedMessage = decodedMessage.strip('<>')
            if strippedMessage.isdigit():
                lightReading = strippedMessage.int()
                print(lightReading)
            else:
                print("Invalid reading")
            
            
            
