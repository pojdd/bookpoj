package top.wangdfeng.bookserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.wangdfeng.bookserver.entity.Book;
import top.wangdfeng.bookserver.service.RelativeService;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class RelativeController {

    @Resource
    private RelativeService service;

    @RequestMapping("/relativebook")
    public List<Book> getRelativeBooks(String bookrelative){
        return service.getRelative(bookrelative);
    }
}
