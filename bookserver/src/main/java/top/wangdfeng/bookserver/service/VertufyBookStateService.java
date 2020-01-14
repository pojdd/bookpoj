package top.wangdfeng.bookserver.service;

import top.wangdfeng.bookserver.entity.BookShelf;

public interface VertufyBookStateService {
    boolean verity(BookShelf bookShelf);
}
