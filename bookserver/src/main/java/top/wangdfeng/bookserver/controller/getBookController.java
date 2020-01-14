package top.wangdfeng.bookserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.wangdfeng.bookserver.entity.Book;
import top.wangdfeng.bookserver.service.GetBookService;

import javax.annotation.Resource;

@RestController
public class getBookController {
    @Resource
    GetBookService getBookService;
    @RequestMapping("/getBookDetailByid")
    public Book getBookByid(String bookid){
        return getBookService.GetBookbyId(bookid);
    }
}
