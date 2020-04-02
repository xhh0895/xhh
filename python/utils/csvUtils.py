#!/usr/bin/python3
# -*- coding: UTF-8 -*-

import csv
import json
import codecs

def read_from_csv(file_path):
    with open(file_path) as f:
        reader = csv.reader(f)
        # print(reader)
        birth_header = next(reader)  # 读取第一行每一列的标题
        print(birth_header)
        for row in reader:
            print(row)
            break
    f.close()

def write_2_csv(file_path,row):
    with open(file_path,"w",encoding='utf8',newline='') as f:
        writer = csv.writer(f)
        writer.writerow(row)
    f.close()

if __name__ == '__main__':
    buildList = []
    f_device = open('C:\\Users\\XHH\\Desktop\\点位\\点位\\红绿灯.csv',"w+",encoding='gb18030',newline='')
    writer = csv.writer(f_device)

    with open('C:\\Users\\XHH\\Desktop\\点位\\点位\\红绿灯.geojson', encoding='utf-8') as f:
        data = json.load(f)
        features = data['features']
        for f in features:
            code = f['id']
            coordinates = f['geometry']['coordinates']
            row = list()
            row.append(code)
            row.append('名称')
            row.append(coordinates[0])
            row.append(coordinates[1])
            row.append('data')
            print(row)
            writer.writerow(row)
    f_device.close()