package top.wangdfeng.bookserver.service;

import org.springframework.stereotype.Service;
import top.wangdfeng.bookserver.entity.Book;

import java.util.List;

public interface BookService {
    /*
    *  获取全部book表中的数据。该数据是raw数据。没有经过分类过滤的原始数据。
    * */
     List<Book> getBookList();

     List<Book> getBookListFantsy();

     List<Book> getBookListCity();

     List<Book> getBookListSelfCultivation();

     List<Book> getBookListRomance();

     List<Book> getBookListGirl();

     List<Book> getBookListCrossing();

     List<Book> getBookListOnlineGame();

     List<Book> getBookListSciFi();
}
