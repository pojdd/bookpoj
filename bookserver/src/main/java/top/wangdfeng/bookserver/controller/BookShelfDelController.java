package top.wangdfeng.bookserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.wangdfeng.bookserver.entity.BookShelf;
import top.wangdfeng.bookserver.service.BookShelfDelService;

import javax.annotation.Resource;

@RestController
public class BookShelfDelController {

    @Resource
    private BookShelfDelService bookShelfDelService;

    @RequestMapping("bookshelf_del")
    public int delete(BookShelf bookShelf){
        return bookShelfDelService.delete(bookShelf);
    }
}
