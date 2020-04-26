#!/usr/bin/python3
# -*- coding: UTF-8 -*-

import pymysql


conn = pymysql.connect(host='127.0.0.1', port=3306, user='root', password='123456', db='test', charset='utf8')
cur = conn.cursor()

# 查询
sql = 'select * from user'
param = ()
cur.execute(sql, param)
res = cur.fetchall()
print(res)

# 添加
sql = 'insert into user(name, age) values(%s, %s)'
param = [('q', '1'), ('w', '2')]
cur.executemany(sql, param)
conn.commit()

# 修改.删除

cur.close()
conn.close()

