#coding:utf-8

from socket import *

HOST='127.0.0.1'
PORT=18888
ADDR=(HOST,PORT)
BUFFERSIZE=1024

cliSocket = socket(AF_INET,SOCK_DGRAM)

while True:
    data = input('>')
    cliSocket.sendto(data.encode(encoding='utf-8'),ADDR)
    msg,addr = cliSocket.recvfrom(BUFFERSIZE)
    print('client recv from server message:',msg.decode(encoding='utf-8'))

cliSocket.close()