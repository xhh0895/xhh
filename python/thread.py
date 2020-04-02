'''线程池:执行操作为谁有空谁执行'''

from concurrent.futures import ThreadPoolExecutor
from threading import current_thread
import time
import requests
 
 
def get(url):
    print('%s GET %s' % (current_thread().name, url))
    time.sleep(3)
    response = requests.get(url)
    if response.status_code == 200:
        res = response.text
    else:
        res = '下载失败'
    return res
 
 
def parse(future):
    time.sleep(1)
    res = future.result()
    print('%s 解析结果为%s' % (current_thread().name, len(res)))
 
 
if __name__ == '__main__':
    urls = [
        'https://www.baidu.com',
        'https://www.sina.com.cn',
        'https://www.tmall.com',
        'https://www.jd.com',
        'https://www.python.org',
        'https://www.openstack.org',
        'https://www.baidu.com',
        'https://www.baidu.com',
        'https://www.baidu.com',
 
    ]
    # 线程池内线程数
    p = ThreadPoolExecutor(4)
    start = time.time()
    for url in urls:
        future = p.submit(get, url)
        future.add_done_callback(parse)
 
    p.shutdown(wait=True)
 
    print('主', current_thread().name)
    print('完成时间', time.time() - start)
 
'''
<concurrent.futures.thread.ThreadPoolExecutor object at 0x00000172EB2053C8>_0 GET https://www.baidu.com
<concurrent.futures.thread.ThreadPoolExecutor object at 0x00000172EB2053C8>_1 GET https://www.sina.com.cn
<concurrent.futures.thread.ThreadPoolExecutor object at 0x00000172EB2053C8>_2 GET https://www.tmall.com
<concurrent.futures.thread.ThreadPoolExecutor object at 0x00000172EB2053C8>_3 GET https://www.jd.com
<concurrent.futures.thread.ThreadPoolExecutor object at 0x00000172EB2053C8>_2 解析结果为233360
<concurrent.futures.thread.ThreadPoolExecutor object at 0x00000172EB2053C8>_2 GET https://www.python.org
<concurrent.futures.thread.ThreadPoolExecutor object at 0x00000172EB2053C8>_0 解析结果为2443
<concurrent.futures.thread.ThreadPoolExecutor object at 0x00000172EB2053C8>_0 GET https://www.openstack.org
<concurrent.futures.thread.ThreadPoolExecutor object at 0x00000172EB2053C8>_3 解析结果为108554
<concurrent.futures.thread.ThreadPoolExecutor object at 0x00000172EB2053C8>_3 GET https://www.baidu.com
<concurrent.futures.thread.ThreadPoolExecutor object at 0x00000172EB2053C8>_1 解析结果为569140
<concurrent.futures.thread.ThreadPoolExecutor object at 0x00000172EB2053C8>_1 GET https://www.baidu.com
<concurrent.futures.thread.ThreadPoolExecutor object at 0x00000172EB2053C8>_1 解析结果为2443
<concurrent.futures.thread.ThreadPoolExecutor object at 0x00000172EB2053C8>_1 GET https://www.baidu.com
<concurrent.futures.thread.ThreadPoolExecutor object at 0x00000172EB2053C8>_3 解析结果为2443
<concurrent.futures.thread.ThreadPoolExecutor object at 0x00000172EB2053C8>_2 解析结果为48821
<concurrent.futures.thread.ThreadPoolExecutor object at 0x00000172EB2053C8>_1 解析结果为2443
<concurrent.futures.thread.ThreadPoolExecutor object at 0x00000172EB2053C8>_0 解析结果为65099
主 MainThread
完成时间 14.592755317687988
'''
