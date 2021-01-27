# -*- coding:utf-8 -*-
import json
import re
import time

import requests
import SQLManager

HEADERS = {
    'Accept': '*/*',
    'Accept-Language': 'en-US,en;q=0.8',
    'Cache-Control': 'max-age=0',
    'User-Agent': 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/48.0.2564.116 Safari/537.36',
    'Connection': 'keep-alive',
    'Referer': 'https://www.meituan.com'
}

streetId = 5464
cityUrl = "https://hz.meituan.com/meishi/b%s/" % streetId
response = requests.get(cityUrl, headers=HEADERS).text
poiLists = re.findall('"poiLists":(.*?),"comHeader"', response)[0]
shopsJson = json.loads(poiLists)
# 获取总页数
shopsNumber = int(shopsJson["totalCounts"])
pageNumber = int(shopsNumber / 15) + 1
print("pageNumber:%d" % pageNumber)
page = 1
# sql语句
sqlManager = SQLManager.SQLManager()
# 添加商品
addShopSql = "insert into meituan_shop" \
             "(shop_id, shop_name, shop_phone, shop_address, shop_collect_date, shop_city_id, shop_district_id, shop_street_id)" \
             "values (%s, %s, %s, %s, %s, %s, %s, %s)"
# 查找父级区域
findParentIdSql = "select * from meituan_area where area_id = %s"
# 重复商品查询
isExistShopSql = "select * from meituan_shop where shop_id = %s"
while page < pageNumber:
    # 分类页面
    pagesUrl = cityUrl + "pn%s/" % page
    print("pagesUrl:" + pagesUrl)
    response = requests.get(pagesUrl, headers=HEADERS).text
    poiLists = re.findall('"poiLists":(.*?),"comHeader"', response)[0]
    shopsPageJson = json.loads(poiLists)
    shopsPage = shopsPageJson["poiInfos"]
    # 遍历单个页面的所有商品
    for shopPage in shopsPage:
        shopId = shopPage["poiId"]
        # 去重判断
        isExistShop = sqlManager.query(isExistShopSql, shopId)
        if isExistShop:
            continue
        # 商品页面
        shopUrl = "https://www.meituan.com/meishi/%s/" % shopId
        response = requests.get(shopUrl, headers=HEADERS).text
        shopJsonData = re.findall('"detailInfo":(.*?),"photos"', response)[0]
        shopJson = json.loads(shopJsonData)
        # 商品数据
        districtId = sqlManager.query(findParentIdSql, streetId, True)["area_parent_id"]
        cityId = sqlManager.query(findParentIdSql, districtId, True)["area_parent_id"]
        collectTime = time.strftime('%Y-%m-%d %H:%M:%S')
        shopData = (
            shopJson["poiId"], shopJson["name"], shopJson["phone"], shopJson["address"],
            collectTime, cityId, districtId, streetId)
        sqlManager.save(addShopSql, shopData)
    page = page + 1

