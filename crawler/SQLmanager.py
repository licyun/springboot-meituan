# -*- coding:utf-8 -*-

import pymysql

# 定义一个数据库相关的配置项
DB_CONFIG = {'host': 'localhost',
             'user': 'root',
             'password': '123456',
             'port': 3306,
             'db': 'meituan_food',
             'charset': 'utf8mb4'
             }


class SQLManager(object):

    # 连接数据库
    # 将conn,cursor作为类的属性，通过connect方法触发生成
    def __init__(self):
        self.conn = None
        self.cursor = None
        self.connect()

    def connect(self):
        self.conn = pymysql.connect(
            host=DB_CONFIG['host'],
            port=DB_CONFIG['port'],
            user=DB_CONFIG['user'],
            password=DB_CONFIG['password'],
            db=DB_CONFIG['db'],
            charset=DB_CONFIG['charset']
        )
        self.cursor = self.conn.cursor(cursor=pymysql.cursors.DictCursor)

    def save(self, sql, args=None):
        print(sql)
        print(args)
        self.cursor.execute(sql, args)
        self.conn.commit()

    def query(self, sql, args=None, one=True):
        self.cursor.execute(sql, args)
        # 提交事务
        self.conn.commit()
        if one:
            return self.cursor.fetchone()
        else:
            return self.cursor.fetchall()

    # 关闭数据库cursor和连接
    def close(self):
        self.cursor.close()
        self.conn.close()