# !/userbin/python3
# -*- coding: UTF-8 -*-

import math

def exc1():
    formater  = '%d*%d=%d'
    for i in range(1,10):
        for j in range(1,i+1):
            print(formater%(j,i,j*i),end='\t')
        print('\n')

def exc2():
    pass
if __name__ == '__main__':
    for x in range(min(2,6),max(2,6),1):
        print(x)
