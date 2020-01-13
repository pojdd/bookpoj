package top.wangdfeng.bookserver.entity;
import java.sql.Blob;

public class Chapter {
    private  int bookid;
    private  int chapter;
    private  String bookcontent;
    private String chaptername;

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


    public String getChaptername() {
        return chaptername;
    }

    public void setChaptername(String chaptername) {
        this.chaptername = chaptername;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "bookid=" + bookid +
                ", chapter=" + chapter +
                ", bookcontent=" + bookcontent +
                ", chaptername='" + chaptername + '\'' +
                '}';
    }

    public Chapter() {
    }

    public Chapter(int bookid, int chapter, String bookcontent, String chaptername) {
        this.bookid = bookid;
        this.chapter = chapter;
        this.bookcontent = bookcontent;
        this.chaptername = chaptername;
    }

    public String getBookcontent() {
        return bookcontent;
    }

    public void setBookcontent(String bookcontent) {
        this.bookcontent = bookcontent;
    }
}
