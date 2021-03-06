#!/usr/bin/python3
# -*- coding: UTF-8 -*-

import requests
import math
import os
from concurrent.futures import ThreadPoolExecutor,ProcessPoolExecutor #线程池，进程池
import threading,time

# OpenStreetMap经纬度转行列号
def deg2num(lat_deg, lon_deg, zoom):
    lat_rad = math.radians(lat_deg)
    n = 2.0 ** zoom
    xtile = int((lon_deg + 180.0) / 360.0 * n)
    ytile = int((1.0 - math.log(math.tan(lat_rad) + (1 / math.cos(lat_rad))) / math.pi) / 2.0 * n)
    return (xtile, ytile)

# OpenStreetMap行列号转经纬度
def num2deg(xtile, ytile, zoom):
    n = 2.0 ** zoom
    lon_deg = xtile / n * 360.0 - 180.0
    lat_rad = math.atan(math.sinh(math.pi * (1 - 2 * ytile / n)))
    lat_deg = math.degrees(lat_rad)
    return (lat_deg, lon_deg)

def downLoadMaptile(zoom, xtile, ytile, file_path):
    base_url = 'https://b.tiles.mapbox.com/v4/mapbox.mapbox-terrain-v2,mapbox.mapbox-streets-v7,yongzhou.cj4rum7sw175l32rr27ky5fzc-1g5a4/%s/%s/%s.vector.pbf?access_token=pk.eyJ1IjoiaHVmdXhpbjAxMSIsImEiOiJjamxxOWF1eHEyZDlqM3Fvc2Q3YXR3OG5uIn0.BQiIakyYvHRgwC-7c-0pQQ' %(zoom, xtile, ytile)

    file_name = file_path + "/" + str(ytile) +".pbf"
    print('start down load'+ file_name)
    flag = False
    try:
        r = requests.get(base_url, timeout=(20,30)) 
        with open(file_name, "wb") as code:
            code.write(r.content)
        code.close()
        print('download %s ok' %file_name)
        flag = True
    except:
        print('网络错误')
        flag =  False
        with open('D:/maptile/guangzhou/err.log', 'a+', encoding='utf8') as log:
            log.write('[%s,%s,%s]' %(x, x_tile, y_tile))
            log.write("\n")
        log.close()
    return flag

def downLoadTask(zoom_path, x_tile, y_tile_range):
    x_tile_path = zoom_path + "/" + str(x_tile)
    if os.path.exists(x_tile_path) != True:
        os.mkdir(x_tile_path)
    for y_tile in range(min(y_tile_range[0],y_tile_range[1]), max(y_tile_range[0],y_tile_range[1] + 1), 1):
    # for y_tile in range(850, 900, 1):
        if(os.path.exists(x_tile_path + "/" + str(y_tile) + ".pbf")):
            print('file is exists')
            continue
        downLoadMaptile(x, x_tile, y_tile, x_tile_path)

if __name__ == '__main__':
    thread_pool = ThreadPoolExecutor(5) #定义5个线程执行此任务

    root_path = 'D:/maptile/guangzhou'
    for x in range(9, 10):
        # 创建层级目录
        zoom_path = root_path + "/" + str(x)
        # print(zoom_path)
        if os.path.exists(zoom_path) != True:
            os.mkdir(zoom_path)
        """
        113.02714,23.290742
        113.56135,22.96238

        23.048169-23.168264
        113.194451-113.341967

        22.26-23.56
        112-114.3
        """
        grid1 = deg2num(18, 110, x)
        grid2 = deg2num(30, 115, x)
        x_tile_range = (grid1[0], grid2[0])
        y_tile_range = (grid1[1], grid2[1])
        print(x_tile_range)
        print(y_tile_range)
        for x_tile in range(min(x_tile_range[0], x_tile_range[1]) - 1, max(x_tile_range[0], x_tile_range[1] + 1), 1):
            thread_pool.submit(downLoadTask,zoom_path,x_tile,y_tile_range)

        # for x_tile in range(1655, 1660, 1):
        #     thread_pool.submit(downLoadTask,zoom_path,x_tile,y_tile_range)
    thread_pool.shutdown(wait=True)
