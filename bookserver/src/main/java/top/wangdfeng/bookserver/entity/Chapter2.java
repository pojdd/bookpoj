package top.wangdfeng.bookserver.entity;

public class Chapter2 {
    private  int bookid;
    private  int chapter;
    private  String bookcontent;

    @Override
    public String toString() {
        return "Chapter2{" +
                "bookid=" + bookid +
                ", chapter=" + chapter +
                ", bookcontent='" + bookcontent + '\'' +
                ", chaptername='" + chaptername + '\'' +
                '}';
    }

    public Chapter2() {
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public int getChapter() {
        return chapter;
    }

    public void setChapter(int chapter) {
        this.chapter = chapter;
    }

    public String getBookcontent() {
        return bookcontent;
    }

    public void setBookcontent(String bookcontent) {
        this.bookcontent = bookcontent;
    }

    public String getChaptername() {
        return chaptername;
    }

    public void setChaptername(String chaptername) {
        this.chaptername = chaptername;
    }

    public Chapter2(int bookid, int chapter, String bookcontent, String chaptername) {
        this.bookid = bookid;
        this.chapter = chapter;
        this.bookcontent = bookcontent;
        this.chaptername = chaptername;
    }

    private String chaptername;
}
