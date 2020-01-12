import pymysql
import datetime
import requests as rs
import re
import os
import time
import random
import _thread
import threading
conn =pymysql.connect(
    host ='127.0.0.1',
    port = 3306,
    user = 'root',
    password ='123',
    database ='test',
    charset ='utf8'
)
cursor =conn.cursor()  #获取一个光标
insertchapterSql ='insert into bookcontent (bookid,chapter,bookcontent,chaptername) values (%s,%s,%s,%s);'
insertbookSql ='insert into book (bookid,bookname,author,pic,summry,bookclass,readcount,updatatime) values (%s,%s,%s,%s,%s,%s,%s,%s);'

def insertchapter(bookid,chapter,bookcontent,chaptername):
    cursor.execute(insertchapterSql, [bookid,chapter,bookcontent,chaptername])
    conn.commit()

def insertbook(bookinfo):
    cursor.execute(insertbookSql, bookinfo)
    conn.commit()

def getPage(num):
    url='http://m.qbbqg.com/full/'+str(num)+'/'
    headers = {
        'Connection': 'close',
    }
    r = rs.get(url,headers=headers)
    s=r.content.decode('gbk')
    return s


imgisGet=False
imgUrl=''
imgWorkCount=8 #12个worker

def imgWork(url):
    global imgisGet
    global imgUrl
    global imgWorkCount #8个worker
    
    if imgisGet==False:
        r = rs.head(url)
        if(r.status_code==200):
            imgisGet=True
            imgUrl=url
    imgWorkCount+=1

def getImg(bookid):
    global imgisGet
    global imgUrl
    global imgWorkCount #8个worker
    imgisGet=False
    imgUrl=''
    imgWorkCount=4
    for index in range(1,25):
        url='http://www.qbbqg.com/files/article/image/'+str(index)+'/'+bookid+'/'+bookid+'s.jpg'
        print("探测图片"+str(index))
        while imgWorkCount<0:
            time.sleep(1)
        if imgisGet:
            return imgUrl
        imgWorkCount-=1
        t = threading.Thread(target = imgWork,args = (url,))
        t.start()
        t.join()
    if imgisGet:
        return imgUrl
    return 'http://m.qbbqg.com/17mb/style/300.jpg'

def getChapterDetail(booksrc):
    url='http://m.qbbqg.com/'+booksrc
    r = rs.get(url)
    s=r.content.decode('gbk')
    return s

def getPageDetail(id,page):#书的id加页码
    url='http://m.qbbqg.com/'+id
    if page>1:
        url+='_'+str(page)
    url+='/'
    headers = {
        'Connection': 'close',
    }
    r = rs.get(url,headers=headers)
    # log(url)
    s=r.content.decode('gbk')
    return s

chapterNum=0 
chapterWorkCount=8 #8个worker
def chapterWork(chapterSrc,bookid,chaptername):
    chapterdata=re.compile(r'<div id="nr1">.*</div>')
    chapter=getChapterDetail(chapterSrc)
    chapterdata=chapterdata.findall(chapter)
    chapterdata=chapterdata[0][14:-6]

    chapterdata = re.sub("&nbsp;"," ",chapterdata)
    chapterdata = re.sub("<br/><br/>","\n",chapterdata)
    insertchapter(bookid,chapterNum,chapterdata,chaptername)
    global chapterWorkCount
    chapterWorkCount+=1

def UpdataPageBook(num=1,start=1):
    pattern = re.compile(r'<div class="full_content"><p class="p1">\[.+</p></div>')
    result = pattern.findall(getPage(num))
    index=0
    for src in result:
        index+=1
        if index<start:
            continue
        print("第"+str(index)+"本")
        log("第"+str(index)+"本\n")
        saveL(num,index+1)
        pattern = re.compile('/[0-9]+')
        pattern1 = re.compile('[0-9]+')
        so = pattern.findall(src)
        if so.__len__()==0:
            continue
        s1 = pattern1.findall(so[0])
        bookid=s1[0]
        if s1.__len__()==0:
            continue
        pattern2=re.compile(r'\[[^<>]+\]')
        s2 = pattern2.findall(src)
        if s2.__len__()==0:
            continue
        booktype=s2[0]

        pattern3=re.compile(r'e">.*</a')
        s3=pattern3.findall(src)
        if s3.__len__()==0:
            continue
        pattern4=re.compile(r'>.*<')
        s4=pattern4.findall(s3[0])
        if s4.__len__()==0:
            continue
        pattern5=re.compile(r'[^>].*[^<]')
        s5=pattern5.findall(s4[0])
        if s5.__len__()==0:
            continue
        
        # downBook(id,booktype+bookid)
        bookname=s5[0]
        pageData=getPageDetail(bookid,1)

        author = re.compile(r'<div class="info_t1">[^<]+')
        result = author.findall(pageData)
        author=result[0][24:]

        print("获取图片")
        pic=getImg(bookid)
        print("获取到图片"+pic)

        summry=re.compile(r'tro">[^<]*')
        result=summry.findall(pageData)
        summry=result[0][5:]
        summry = re.sub("\s","",summry)

        updatatime=re.compile(r't4">[^<]*')
        result=updatatime.findall(pageData)
        updatatime=result[0][7:]

        random.seed(bookid)
        count=random.randint(0,10000)

        insertbook([bookid,bookname,author,pic,summry,booktype,count,updatatime])
        
        detailPage=re.compile(r'option value="/[0-9_]+/')
        result=detailPage.findall(pageData)

        global chapterNum
        chapterNum=0
        for index in range(1,result.__len__()+1):
            chapter=re.compile(r'<div class="info_newest">')
            pageData=getPageDetail(bookid,index)
            pageData=re.split(chapter, pageData)

            chapter=re.compile(r'<div class="listpage">')
            pageData=pageData[2]
            pageData=re.split(chapter, pageData)
            pageData=pageData[0]

            chapter=re.compile(r'[/0-9]*.html">[^<]*<')
            result=chapter.findall(pageData)
            # global chapterWorkCount
            # chapterWorkCount=8
            for src in result:
                chapterNum+=1
                chapterdata=re.compile(r'>')
                pageData=re.split(chapterdata, src)
                chapterSrc=pageData[0][:-1]
                chaptername=pageData[1][:-1]
                print("第"+str(chapterNum)+" "+chaptername)
                # while chapterWorkCount<0:
                #     time.sleep(1)
                # chapterWorkCount-=1
                # t = threading.Thread(target = chapterWork,args = (chapterSrc,bookid,chaptername))
                # t.start()
                # t.join()
                chapterdata=re.compile(r'<div id="nr1">.*</div>')
                print("获取详情")
                chapter=getChapterDetail(chapterSrc)
                chapterdata=chapterdata.findall(chapter)
                chapterdata=chapterdata[0][14:-6]
                print("数据处理")
                chapterdata = re.sub("&nbsp;"," ",chapterdata)
                chapterdata = re.sub("<br/><br/>","\n",chapterdata)
                print("插入数据库")
                insertchapter(bookid,chapterNum,chapterdata,chaptername)
                global chapterWorkCount
                chapterWorkCount+=1
                if(chapterNum>100):
                    break
            if(chapterNum>100):
                break
        if(chapterNum>100):
            break

def log(str1):
    with open("log.txt", "a+") as code:
        code.write(str1)

def saveL(a,b):
    fd = open("save", mode="w", encoding="utf-8")
    fd.write(str(a)+" "+str(b))
    fd.close()
#---------初始化----------
if not os.path.isfile("save"):  # 无文件时创建
    fd = open("save", mode="w", encoding="utf-8")
    fd.write("1 1")
    fd.close()

with open("save") as fp:#初始化存档
    content=fp.read()
getnum=re.compile(r'[0-9]+')
nums=getnum.findall(content)

#---------初始化----------
for pagenum in range(int(nums[0]),int(nums[0])+1):#下载上次没下载好的页面
    log('-----------------------------------\n')
    log('爬取'+str(pagenum)+'页\n')
    log('-----------------------------------\n')
    UpdataPageBook(pagenum,int(nums[1]))
    pass

for pagenum in range(int(nums[0])+1,1218):#继续其他页面的下载
    log('-----------------------------------\n')
    log('爬取'+str(pagenum)+'页\n')
    log('-----------------------------------\n')
    UpdataPageBook(pagenum)
    pass
# insertchapter(2,1,'dddd')
# insertbook([11,'bookname','author','pic','summry','bookclass',11,'updatatime'])

cursor.close()
conn.close()



#获取详情页面以供测试
# log(getPageDetail('7978',1))