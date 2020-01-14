package top.wangdfeng.bookserver.dao;

import top.wangdfeng.bookserver.entity.Book;

public interface GetBookbyIdDao {
    Book getBookById(String id);
}
