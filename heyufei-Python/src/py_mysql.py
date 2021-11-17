import pymysql


# 创建数据表
# def jianbiao():
#     try:
#         db = pymysql.connect(DBHOST, DBUSER, DBPASS, DBNAME)
#         cur = db.cursor()   #声明游标
#         cur.execute("DROP TABLE IF EXISTS activities")   #创建数据表 名为比赛 若存在则删除
#         sql = 'CREATE TABLE activities(name CHAR(100) NOT NULL ,adress CHAR (100)'
#         cur.execute(sql)
#         print("数据表创建成功！")
#     except pymysql.Error as e:
#         print("数据表创建失败！"+str(e))
try:
    db = pymysql.connect(host='120.24.145.157', user='root', password='Jsu123456.', db='fly_school')
    cur = db.cursor()  # 声明游标
    cur.execute("DROP TABLE IF EXISTS activities")  # 创建数据表 名为比赛 若存在则删除
    sql = 'CREATE TABLE activities(name varchar(100) NOT NULL, adress varchar(100))'
    cur.execute(sql)
    print("数据表创建成功！")
except pymysql.Error as e:
    print("数据表创建失败！" + str(e))

try:
    db = pymysql.connect(host='120.24.145.157', user='root', password='Jsu123456.', db='fly_school')
    cur = db.cursor()  # 声明游标
    for data in datalist :
        data = tuple(data)  #列表转元祖 我老是搞错  一定要记得
        sql = 'INSERT INTO activities(name,adress) VALUE (%s,%s)' # 表名  字段名 插入的值
        # print(sql)   #打印从元祖中获取到的东西
        value = (data[0],data[1])  #传递元组的值  status 初始化0
        cur.execute(sql,value)  # 将数据进行提交
        db.commit()  # 数据库的提交
    print("数据插入成功!")
except pymysql.Error as e:
    print("数据插入失败"+str(e))
    db.rollback()   #数据插入失败返回原先状态

