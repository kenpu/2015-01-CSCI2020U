import sys
from socket import socket, AF_INET, SOCK_STREAM

host = sys.argv[1]
port = int(sys.argv[2])

s = socket(AF_INET, SOCK_STREAM)
s.connect((host, port))
data = s.recv(1024)
print data
s.close()

