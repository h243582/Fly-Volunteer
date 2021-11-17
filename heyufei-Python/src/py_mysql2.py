import requests
from bs4 import BeautifulSoup
import re
import pymysql


def create():
    db = pymysql.connect(host='120.24.145.157', user='root', password='Jsu123456.', db='fly_school')

    cursor = db.cursor()
    cursor.execute("DROP TABLE IF EXISTS EMPLOYER")

    sql = """CREATE TABLE EMPLOYER (
            ID INT PRIMARY KEY AUTO_INCREMENT,
            LOGO  CHAR(255),
            PRICE CHAR(20),
            AUTHER CHAR(255) )"""

    cursor.execute(sql)

    db.close()


def insert(value):
    db = pymysql.connect(host='120.24.145.157', user='root', password='Jsu123456.', db='fly_school')

    cursor = db.cursor()
    sql = "INSERT INTO EMPLOYER(LOGO,PRICE,AUTHER) VALUES (%s, %s,  %s)"
    try:
        cursor.execute(sql, value)
        db.commit()
        print('插入数据成功')
    except:
        db.rollback()
        print("插入数据失败")
    db.close()


create()  # 创建表

# re匹配需要的数据
pertern = re.compile(
    r'<img.*?data-original="(.*?)".*?<span class="search_now_price">(.*?)</span>.*?<a.*?单品作者.*?title="(.*?)">.*?</a>',
    re.S)
# 添加请求头   修改user-agent来伪装浏览器
headers = {
    'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.110 Safari/537.36'}
url = 'http://category.dangdang.com/cp01.19.34.00.00.00.html'
res = requests.get(url, headers=headers)
print(res.status_code)

soup = BeautifulSoup(res.text, 'html.parser')
data = soup.find_all('ul', attrs={'class': 'bigimg'})
data = str(data)
item = re.findall(pertern, data)
for i in item:
    print(i)
    insert(i)
