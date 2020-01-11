package top.wangdfeng.bookserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.wangdfeng.bookserver.entity.Book;
import top.wangdfeng.bookserver.service.BookService;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;

@RestController
public class BookstoreController {

    /*
    * bookstore_category_one
    *       玄幻接口
    * */

    @Resource
    private BookService bookService;

    @RequestMapping("/bookstore_category_one")
    public List<Book> getFantasyNovel(){
        return bookService.getBookListFantsy();
    }

}
