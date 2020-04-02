#!/usr/bin/python3
# -*- coding: UTF-8 -*-

import csv
import json
import sys
import codecs

def trans(path):
    jsonData = codecs.open(path+'.geojson', 'r', 'utf-8')
    # csvfile = open(path+'.csv', 'w') # 此处这样写会导致写出来的文件会有空行
    # csvfile = open(path+'.csv', 'wb') # python2下
    csvfile = open(path+'.csv', 'w', newline='') # python3下
    writer = csv.writer(csvfile, delimiter='\t', quoting=csv.QUOTE_ALL)
    flag = True
    for line in jsonData:
        print(line)
        dic = json.loads(line[0:-1])
        if flag:
            # 获取属性列表
            keys = list(dic.keys())
            print (keys)
            writer.writerow(keys) # 将属性列表写入csv中
            flag = False
        # 读取json数据的每一行，将values数据一次一行的写入csv中
        writer.writerow(list(dic.values()))
    jsonData.close()
    csvfile.close()

if __name__ == '__main__':
    # path="F:/7G/pyWorkspace/DbCode/features" # 获取path参数
    # print (path)
    # trans(path)
    f = open("qwe.json","r",encoding='utf8')

    outf=open("2.csv","w",encoding='utf8',newline='')
    
    writer2 = csv.writer(outf)
    content=json.loads(f.read())
    # print(content)
    for key2 in content["features"]:
        print (key2['geometry']['coordinates'])
        posX = key2['geometry']['coordinates'][0]
        posY = key2['geometry']['coordinates'][1]
        rowStr = [posX,posY]
        writer2.writerow(rowStr)
    f.close()
    outf.close()
