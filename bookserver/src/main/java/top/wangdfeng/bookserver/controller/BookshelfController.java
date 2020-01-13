package top.wangdfeng.bookserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.wangdfeng.bookserver.entity.Book;
import top.wangdfeng.bookserver.service.BookshelfService;

import javax.annotation.Resource;
import java.util.List;

/*
* 返回用户书架的Contronler
* */
@RestController
public class BookshelfController {
    @Resource
    private BookshelfService service;

    @RequestMapping("/getshelfs")
    public List<Book> getShelf(String userid){
        return service.getUserBookShelf(userid);
    }
}
