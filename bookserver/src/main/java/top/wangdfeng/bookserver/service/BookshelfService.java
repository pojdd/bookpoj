package top.wangdfeng.bookserver.service;

import top.wangdfeng.bookserver.entity.Book;

import java.util.List;

public interface BookshelfService {
    List<Book> getUserBookShelf(String userid);
}
