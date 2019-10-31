#!/usr/bin/python3
# -*- coding: UTF-8 -*-

from datetime import datetime
import base64
'''
中文c测试git
'''
# print(datetime.now())

# cday = datetime.strptime('2018-02-13 11:11:11','%Y-%m-%d %H:%M:%S')
# print(cday)

s = base64.b64encode('在Python中使用BASE 64编码'.encode('utf-8'))
print(s)
d = base64.b64decode(s).decode('utf-8')
print(d)

s = base64.urlsafe_b64encode('在Python中使用BASE 64编码'.encode('utf-8'))
print(s)
d = base64.urlsafe_b64decode(s).decode('utf-8')
print(d)