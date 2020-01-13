package top.wangdfeng.bookserver.entity;

public class BookShelf {
    private String userid;
    private String bookid;

    public BookShelf() {
    }

    @Override
    public String toString() {
        return "BookShelf{" +
                "userid='" + userid + '\'' +
                ", bookid='" + bookid + '\'' +
                '}';
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    public BookShelf(String userid, String bookid) {
        this.userid = userid;
        this.bookid = bookid;
    }
}
