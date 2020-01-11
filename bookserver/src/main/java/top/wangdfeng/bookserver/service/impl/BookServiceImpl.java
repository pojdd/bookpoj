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
}
