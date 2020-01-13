package top.wangdfeng.bookserver.entity;

public class SerachKey {
    private String bookname;
    private String bookid;

    public SerachKey() {
    }

    public SerachKey(String bookname, String bookid) {
        this.bookname = bookname;
        this.bookid = bookid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    @Override
    public String toString() {
        return "key{" +
                "bookname='" + bookname + '\'' +
                ", bookid=" + bookid +
                '}';
    }
}
