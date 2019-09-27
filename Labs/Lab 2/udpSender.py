# Source: https://pymotw.com/2/socket/udp.html

import socket, sys, time

host = sys.argv[1]
textport = sys.argv[2]
n = sys.argv[3]
count = int(n)

s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
port = int(textport)
server_address = (host, port)

for x in range(1,count+1,1):
    string1 = "Message" + str(x) 
    s.sendto(string1.encode('utf-8'), server_address)    
    
    getback, address = s.recvfrom(port)
    print(getback)

s.shutdown(1)

