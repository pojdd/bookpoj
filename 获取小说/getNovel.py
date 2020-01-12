import requests as rs
import re
import os
import time
def downBook(id,name):
    downUrl='http://www.qbbqg.com/modules/article/txtarticle.php?id='
    log("下载链接:"+downUrl+id+"\n")
    r = rs.get(downUrl+id)
    with open("./book/"+name+".txt", "wb") as code:
            code.write(r.content)
def getPage(num):
    url='http://m.qbbqg.com/full/'+str(num)+'/'
    r = rs.get(url)
    s=r.content.decode('gbk')
    return s
def DownPageBook(num=1,start=1):
    pattern = re.compile(r'<div class="full_content"><p class="p1">\[.+</p></div>')
    result = pattern.findall(getPage(num))
    index=0
    for src in result:
        index+=1
        if index<start:
            continue
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
        log('下载第'+str(index)+"本"+booktype+bookname+" "+bookid+'\n')

        print("bookid:"+str(bookid)+" bookname:"+str(booktype+bookname))

        downBook(bookid,booktype+bookname)
        print("保存"+str(num)+" "+str(index))
        saveL(num,index)
        print("下载和存档完成开始延迟2s")
        time.sleep(2)
        print("延迟结束")
        pass
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

if  os.path.exists('book')==False:#初始化目录
    os.mkdir('book')

#---------初始化----------

for pagenum in range(int(nums[0]),int(nums[0])+1):#下载上次没下载好的页面
    log('-----------------------------------\n')
    log('下载第'+str(pagenum)+'页\n')
    log('-----------------------------------\n')
    DownPageBook(pagenum,int(nums[1]))
    pass

for pagenum in range(int(nums[0])+1,1218):#继续其他页面的下载
    log('-----------------------------------\n')
    log('下载第'+str(pagenum)+'页\n')
    log('-----------------------------------\n')
    DownPageBook(pagenum)
    pass


# with open("data.txt", "a+") as code:
#         code.write(getPage(6))

