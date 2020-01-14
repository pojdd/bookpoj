package top.wangdfeng.bookserver.service;

import top.wangdfeng.bookserver.entity.Book;

import java.util.List;

public interface RelativeService {
    List<Book> getRelative(String classes);
}
