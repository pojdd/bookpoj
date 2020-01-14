package top.wangdfeng.bookserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.wangdfeng.bookserver.entity.BookShelf;
import top.wangdfeng.bookserver.service.VertufyBookStateService;

import javax.annotation.Resource;

@RestController
public class VertifyBookStateController {


    @Resource
    private VertufyBookStateService stateService;

    @RequestMapping("/vertify")
    public boolean vertify(BookShelf bookShelf){
        return stateService.verity(bookShelf);
    }
}
