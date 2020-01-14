package top.wangdfeng.bookserver.service;

import top.wangdfeng.bookserver.entity.Book;

public interface GetBookService {
    Book GetBookbyId(String bookid);
}
