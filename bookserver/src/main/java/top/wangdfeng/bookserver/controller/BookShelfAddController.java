package top.wangdfeng.bookserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.wangdfeng.bookserver.entity.BookShelf;
import top.wangdfeng.bookserver.service.BookShelfAddService;
import top.wangdfeng.bookserver.service.BookShelfDelService;

import javax.annotation.Resource;

@RestController
public class BookShelfAddController {

    @Resource
    private BookShelfAddService bookShelfAddService;

    @RequestMapping("bookshelf_add")
    public int delete(BookShelf bookShelf){
        return bookShelfAddService.add(bookShelf);
    }
}
