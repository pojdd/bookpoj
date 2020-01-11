# import pymysql
 
# conn = pymysql.connect(
#     host='127.0.0.1',
#     port=3306,
#     user='root',
#     password='123',
#     database='test',
#     charset='utf8'
# )
# # 获取一个光标
# cursor = conn.cursor()
 
# # 定义要执行的sql语句
# sql = 'insert into bookcontent(bookid,chapter,bookcontent) values(%s,%s,%s);'
# data = [
#     (123, 1,'1agfsagfas23'),
#     (123, 2,'1xascfsa23'),
#     (123, 3,'112312423'),
# ]
# # 拼接并执行sql语句
# cursor.executemany(sql, data)

# # 涉及写操作要注意提交
# conn.commit()
 
# # 关闭连接
# cursor.close()
# conn.close()



import pymysql
conn =pymysql.connect(
    host ='127.0.0.1',
    port = 3306,
    user = 'root',
    password ='123',
    database ='test',
    charset ='utf8'
)
cursor =conn.cursor()  #获取一个光标
sql ='insert into bookcontent (bookid,chapter) values (%s,%s);'
 
name = '11'
pwd = '11'
cursor.execute(sql, [name, pwd])
conn.commit()
cursor.close()
conn.close()