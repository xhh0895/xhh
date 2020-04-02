#coding:utf-8
from socket import *

HOST='127.0.0.1'
PORT=19991
ADDR=(HOST,PORT)
BUFFERSIZE=1024
#创建客户端套接字
clientSocket = socket(AF_INET,SOCK_STREAM)
clientSocket.connect(ADDR)
clientSocket.send('你好啊'.encode(encoding='utf-8'))

# while True:
#     # data = input('>')
#     clientSocket.send('你好啊'.encode(encoding='utf-8'))
#     msg = clientSocket.recv(BUFFERSIZE).decode(encoding='utf-8')
#     print(msg)
clientSocket.close()