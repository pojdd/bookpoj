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

    @Override
    public List<Book> getBookListFantsy() {
        List<Book> newbooks=new ArrayList<>();
        List<Book> books=getBookList();
        for(Book book:books){
            String string=book.getBookclass();
            if(string.equals("[玄幻]")){
                newbooks.add(book);
            }
        }
        return newbooks;
    }

    @Override
    public List<Book> getBookListCity() {
        List<Book> newbooks=new ArrayList<>();
        List<Book> books=getBookList();
        for(Book book:books){
            String string=book.getBookclass();
            if(string.equals("[都市]")){
                newbooks.add(book);
            }
        }
        return newbooks;
    }

    @Override
    public List<Book> getBookListSelfCultivation() {
        List<Book> newbooks=new ArrayList<>();
        List<Book> books=getBookList();
        for(Book book:books){
            String string=book.getBookclass();
            if(string.equals("[修真]")){
                newbooks.add(book);
            }
        }
        return newbooks;
    }

    @Override
    public List<Book> getBookListRomance() {
        List<Book> newbooks=new ArrayList<>();
        List<Book> books=getBookList();
        for(Book book:books){
            String string=book.getBookclass();
            if(string.equals("[言情]")){
                newbooks.add(book);
            }
        }
        return newbooks;
    }

    @Override
    public List<Book> getBookListGirl() {
        List<Book> newbooks=new ArrayList<>();
        List<Book> books=getBookList();
        for(Book book:books){
            String string=book.getBookclass();
            if(string.equals("[女生]")){
                newbooks.add(book);
            }
        }
        return newbooks;
    }

    @Override
    public List<Book> getBookListCrossing() {
        List<Book> newbooks=new ArrayList<>();
        List<Book> books=getBookList();
        for(Book book:books){
            String string=book.getBookclass();
            if(string.equals("[穿越]")){
                newbooks.add(book);
            }
        }
        return newbooks;
    }

    @Override
    public List<Book> getBookListOnlineGame() {
        List<Book> newbooks=new ArrayList<>();
        List<Book> books=getBookList();
        for(Book book:books){
            String string=book.getBookclass();
            if(string.equals("[网游]")){
                newbooks.add(book);
            }
        }
        return newbooks;
    }

    @Override
    public List<Book> getBookListSciFi() {
        List<Book> newbooks=new ArrayList<>();
        List<Book> books=getBookList();
        for(Book book:books){
            String string=book.getBookclass();
            if(string.equals("[科幻]")){
                newbooks.add(book);
            }
        }
        return newbooks;
    }
}
