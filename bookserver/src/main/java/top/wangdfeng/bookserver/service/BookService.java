package top.wangdfeng.bookserver.service;

import org.springframework.stereotype.Service;
import top.wangdfeng.bookserver.entity.Book;

import java.util.List;

public interface BookService {
    /*
    *  获取全部book表中的数据。该数据是raw数据。没有经过分类过滤的原始数据。
    * */
    public List<Book> getBookList();

    public List<Book> getBookListFantsy();
}
