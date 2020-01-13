package top.wangdfeng.bookserver.dao;

import top.wangdfeng.bookserver.entity.Book;

import java.util.List;

public interface BookshelfDao {
    List<Book> queryBooksByUserId(String userid);
}
