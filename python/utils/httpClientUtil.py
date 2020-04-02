#!/usr/bin/python3
# -*- coding: UTF-8 -*-

import time
import requests
import json


'''
requests库http操作：

requests.get('https://github.com/timeline.json') #GET请求
requests.post('http://httpbin.org/post') #POST请求
requests.put('http://httpbin.org/put') #PUT请求
requests.delete('http://httpbin.org/delete') #DELETE请求
requests.head('http://httpbin.org/get') #HEAD请求
requests.options('http://httpbin.org/get') #OPTIONS请求

response
r.status_code #响应状态码
r.raw #返回原始响应体，也就是 urllib 的 response 对象，使用 r.raw.read() 读取
r.content #字节方式的响应体，会自动为你解码 gzip 和 deflate 压缩
r.text #字符串方式的响应体，会自动根据响应头部的字符编码进行解码
r.headers #以字典对象存储服务器响应头，但是这个字典比较特殊，字典键不区分大小写，若键不存在则返回None
#*特殊方法*#
r.json() #Requests中内置的JSON解码器
r.raise_for_status() #失败请求(非200响应)抛出异常
'''

def get():

	headers = {'content-type': 'application/json'}

	for i in range(1,101):
		data={'sn': 'DATA001', 'status': '1', 'BATCH': i}
		requests.post('http://192.168.49.91:8090/qjzh-iot-http/report/tenant1/virtualApp/PROD1', data=json.dumps(data), headers=headers)
		time.sleep(1)

res = requests.get('https://github.com/timeline.json') #GET请求
print('状态码')
print(res.status_code)
print("响应头")
print(res.headers)

print(res.content)
print(res.text)



# requests.post('http://httpbin.org/post') #POST请求content

# requests.put('http://httpbin.org/put') #PUT请求
# requests.delete('http://httpbin.org/delete') #DELETE请求
# requests.head('http://httpbin.org/get') #HEAD请求
# requests.options('http://httpbin.org/get') #OPTIONS请求