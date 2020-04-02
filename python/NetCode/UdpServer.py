#coding:utf-8

from socket import *

HOST=''
PORT=8989
ADDR=(HOST,PORT)
BUFFERSIZE=1024

serverSocket = socket(AF_INET,SOCK_DGRAM)
serverSocket.bind(ADDR)
while True:
    data,addr = serverSocket.recvfrom(BUFFERSIZE)
    print('recv msg ',data.decode(encoding='utf-8'))
    serverSocket.sendto('Hi'.encode(encoding='utf-8'),addr)

serverSocket.close()