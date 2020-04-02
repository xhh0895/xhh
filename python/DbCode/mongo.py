#！/usr/bin/python3
# -*- coding: UTF-8 -*-

from pymongo import MongoClient
import time

conn = MongoClient('127.0.0.1', 27017)
db = conn.test
my_set = db.test_set

beginTime = time.time()
for x in range(1,100000):
   my_set.insert({"name": x, "age":x})
endTime = time.time()
print(endTime - beginTime)

beginTime = time.time()
with open('F:/git_repo/python/DbCode/test.txt',"w",encoding='utf8',newline='') as f:
    for x in range(1,10000):
        f.write(str({"name": x, "age": x}))
f.close()
endTime = time.time()
print(endTime - beginTime)