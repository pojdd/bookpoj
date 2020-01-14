package top.wangdfeng.bookserver.dao;

import top.wangdfeng.bookserver.entity.BookShelf;

public interface VertifyBookStateDao {
    boolean vertify(BookShelf shelf);
}
