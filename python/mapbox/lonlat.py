#!/usr/bin/python3
# -*- coding: UTF-8 -*-

import math
import os
import urllib.request


# OpenStreetMap经纬度转行列号
def deg2num(lat_deg, lon_deg, zoom):
    lat_rad = math.radians(lat_deg)
    n = 2.0 ** zoom
    xtile = int((lon_deg + 180.0) / 360.0 * n)
    ytile = int((1.0 - math.log(math.tan(lat_rad) + (1 / math.cos(lat_rad))) / math.pi) / 2.0 * n)
    return xtile, ytile


# OpenStreetMap行列号转经纬度
def num2deg(xtile, ytile, zoom):
    n = 2.0 ** zoom
    lon_deg = xtile / n * 360.0 - 180.0
    lat_rad = math.atan(math.sinh(math.pi * (1 - 2 * ytile / n)))
    lat_deg = math.degrees(lat_rad)
    return lat_deg, lon_deg


def downLoadMaptile(zoom, xtile, ytile, file_path):
    base_url = 'https://b.tiles.mapbox.com/v4/mapbox.mapbox-terrain-v2,mapbox.mapbox-streets-v7,yongzhou.cj4rum7sw175l32rr27ky5fzc-1g5a4/%s/%s/%s.vector.pbf?access_token=pk.eyJ1IjoiaHVmdXhpbjAxMSIsImEiOiJjamxxOWF1eHEyZDlqM3Fvc2Q3YXR3OG5uIn0.BQiIakyYvHRgwC-7c-0pQQ' % (
    zoom, xtile, ytile)
    request = urllib.request.Request(base_url)
    try:
        r_response = urllib.request.urlopen(request, timeout=30)
    except:
        print('网络错误')
        return False
    if r_response.getcode() == 200:
        r = r_response.read()
        r_response.getcontent
        file_name = file_path + "/" + str(ytile) + ".vector.pbf"
        with open(file_name, 'wb') as f:
            f.write(r)
        f.close()
        return True
    else:
        return False


if __name__ == '__main__':
    print(num2deg(1675, 884, 11))
