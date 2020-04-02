#!/usr/bin/python3
# -*- coding: UTF-8 -*-

import os
import time
import shutil

def  renameFile(src_dir):
    file_list = os.listdir(src_dir)
    for temp in file_list:
       print(temp)
       os.rename(src_dir+temp,src_dir+temp.replace('动力节点_',''))

def use_mutable_default_param(idx=0, ids=[]):
    ids.append(idx)
    print(idx)
    print(ids)

def strReverse(strDemo):
    return strDemo[::-1]

def list_file(dir_path, filters):
	res_list = []
	file_list = os.listdir(dir_path)
	for f in file_list:
		path = os.path.join(dir_path, f)
		if os.path.isdir(path):
			res_list.extend(list_file(path, filters))
		else:
			if len(filters) == 0:
				res_list.append(path)
				continue
			suffex = os.path.splitext(path)[1].replace('.', '').lower()
			if suffex in tuple(filters):
				res_list.append(path)
	return res_list

def move_file(file_list, dest_path):
	pass

if __name__ == '__main__':
	list = list_file('F:\\svn\\etown-bigdata\\手工数据导入20190926\\开发区统计局', ('xlsx', 'xls', 'csv'))
	print(len(list))
	for f in list:
		file_name = os.path.basename(f)
		print(file_name)
	# dest_path = 'F:\\svn\\etown-bigdata\\手工数据导入\\规划分局'
	# for f in list:
	# 	print(f)
	# 	file_name = os.path.basename(f)
	# 	shutil.copyfile(f, dest_path + '\\' + file_name)