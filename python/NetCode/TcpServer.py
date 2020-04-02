#coding:utf-8

from socket import *
import threading

def serverHandler(sock, addr):
    print('Accept new connection from %s:%s...' % addr)
    while(True):
        data = sock.recv(1024)
        if not data or data.decode('utf-8') == 'exit':
            break
        print(data.decode('utf-8'))
    sock.close()

HOST='127.0.0.1'
PORT=8989
ADDR=(HOST,PORT)
BUFFERSIZE=1024
#创建服务端套接字
ss = socket(AF_INET,SOCK_STREAM)

#绑定地址
ss.bind(ADDR)
#设置监听数
ss.listen(5)

while True:
    print('witting for connect...')
    # 接受一个连接
    sock,addr = ss.accept()
    # 创建线程处理该连接

    print('...connected from ',addr)
    t = threading.Thread(target = serverHandler, args = (sock,addr))
    t.start()
ss.close()


