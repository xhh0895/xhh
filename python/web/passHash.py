#!/usr/bin/python3
# -*- coding: UTF-8 -*-

from urllib import request
import json

if __name__ == '__main__':
    url = 'https://hqiot.bjut.edu.cn/API/Alarm'
    headers = {
        'Cookie':'TOSSessionID=CD8D1913446E0AF73788BAEA57CC4DF1E72EB4F9'
    }
    r = request.Request(headers=headers, url=url)
    print(r)
    response_obj = request.urlopen(r)
    html_code = response_obj.read().decode('utf-8')
    with open('res.txt','w+') as f:
        f.write(html_code)