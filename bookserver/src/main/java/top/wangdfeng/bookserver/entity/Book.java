package top.wangdfeng.bookserver.entity;

public class Book {
    private int bookid;
    private String bookname;
    private String author;
    private String pic;
    private String summry;
    private String bookclass;
    private int readcount;
    private String updatatime;
    private String shortsummry;

    public String getShortsummry() {
        return shortsummry;
    }

    public void setShortsummry(String shortsummry) {
        this.shortsummry = shortsummry;
    }

    public Book() {
    }

    public Book(int bookid, String bookname, String author, String pic, String summry, String bookclass, int readcount, String updatatime) {
        this.bookid = bookid;
        this.bookname = bookname;
        this.author = author;
        this.pic = pic;
        this.summry = summry;
        this.bookclass = bookclass;
        this.readcount = readcount;
        this.updatatime = updatatime;
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getSummry() {
        return summry;
    }

    public void setSummry(String summry) {
        this.summry = summry;
    }

    public String getBookclass() {
        return bookclass;
    }

    public void setBookclass(String bookclass) {
        this.bookclass = bookclass;
    }

    public int getReadcount() {
        return readcount;
    }

    public void setReadcount(int readcount) {
        this.readcount = readcount;
    }

    public String getUpdatatime() {
        return updatatime;
    }

    public void setUpdatatime(String updatatime) {
        this.updatatime = updatatime;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookid=" + bookid +
                ", bookname='" + bookname + '\'' +
                ", author='" + author + '\'' +
                ", pic='" + pic + '\'' +
                ", summry='" + summry + '\'' +
                ", bookclass='" + bookclass + '\'' +
                ", readcount=" + readcount +
                ", updatatime='" + updatatime + '\'' +
                '}';
    }
}
