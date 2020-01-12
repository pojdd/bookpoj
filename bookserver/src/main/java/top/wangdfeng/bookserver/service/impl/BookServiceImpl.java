package top.wangdfeng.bookserver.service.impl;

import org.springframework.stereotype.Service;
import top.wangdfeng.bookserver.dao.BookStoreDao;
import top.wangdfeng.bookserver.entity.Book;
import top.wangdfeng.bookserver.service.BookService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Resource
    private BookStoreDao bookStoreDao;

    @Override
    public List<Book> getBookList() {
        bookStoreDao.queryBook();
        return bookStoreDao.queryBook();
    }

    /*
    *  获取排名前6的玄幻小说业务
    *
    * */
    @Override
    public List<Book> getBookListFantsy() {
        List<Book> newbooks=new ArrayList<>();
        List<Book> books=getBookList();
        int num=0;
        for(Book book:books){
            String string=book.getBookclass();
            if(string.equals("[玄幻]")&&num<6){
                newbooks.add(book);
                num++;
            }
        }
        return newbooks;
    }

    /*
     *  获取排名前6的都市小说业务
     *
     * */

    @Override
    public List<Book> getBookListCity() {
        List<Book> newbooks=new ArrayList<>();
        List<Book> books=getBookList();
        int num=0;
        for(Book book:books){
            String string=book.getBookclass();
            if(string.equals("[都市]")&&num<3){
                newbooks.add(book);
                num++;
            }
        }
        return newbooks;
    }

    /*
     *  获取排名前6的修真小说业务
     *
     * */

    @Override
    public List<Book> getBookListSelfCultivation() {
        List<Book> newbooks=new ArrayList<>();
        List<Book> books=getBookList();
        int num=0;
        for(Book book:books){
            String string=book.getBookclass();
            if(string.equals("[修真]")&&num<6){
                newbooks.add(book);
                num++;
            }
        }
        return newbooks;
    }

    /*
     *  获取排名前6的言情小说业务
     *
     * */
    @Override
    public List<Book> getBookListRomance() {
        List<Book> newbooks=new ArrayList<>();
        List<Book> books=getBookList();
        int num=0;
        for(Book book:books){
            String string=book.getBookclass();
            if(string.equals("[言情]")&&num<3){
                newbooks.add(book);
                num++;
            }
        }
        return newbooks;
    }

    /*
     *  获取排名前6的女生小说业务
     *
     * */
    @Override
    public List<Book> getBookListGirl() {
        List<Book> newbooks=new ArrayList<>();
        List<Book> books=getBookList();
        int num=0;
        for(Book book:books){
            String string=book.getBookclass();
            if(string.equals("[女生]")&&num<6){
                newbooks.add(book);
                num++;
            }
        }
        return newbooks;
    }

    /*
     *  获取排名前6的穿越小说业务
     *
     * */

    @Override
    public List<Book> getBookListCrossing() {
        List<Book> newbooks=new ArrayList<>();
        List<Book> books=getBookList();
        int num=0;
        for(Book book:books){
            String string=book.getBookclass();
            if(string.equals("[穿越]")&&num<3){
                newbooks.add(book);
                num++;
            }
        }
        return newbooks;
    }

    /*
     *  获取排名前6的网游小说业务
     *
     * */

    @Override
    public List<Book> getBookListOnlineGame() {
        List<Book> newbooks=new ArrayList<>();
        List<Book> books=getBookList();
        int num=0;
        for(Book book:books){
            String string=book.getBookclass();
            if(string.equals("[网游]")&&num<6){
                newbooks.add(book);
                num++;
            }
        }
        return newbooks;
    }

    /*
     *  获取排名前6的科幻小说业务
     *
     * */
    @Override
    public List<Book> getBookListSciFi() {
        List<Book> newbooks=new ArrayList<>();
        List<Book> books=getBookList();
        int  num=0;
        for(Book book:books){
            String string=book.getBookclass();
            if(string.equals("[科幻]")&&num<3){
                newbooks.add(book);
                num++;
            }
        }
        return newbooks;
    }
}
