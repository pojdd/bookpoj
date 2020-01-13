package top.wangdfeng.bookserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.wangdfeng.bookserver.entity.Chapter;
import top.wangdfeng.bookserver.service.ChapterService;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ChapterController {

    @Resource
    private ChapterService chapterService;

    @RequestMapping("/getChapters")
    public List<Chapter> getChapter(String bookid){
        return chapterService.getChapters(bookid);
    }
}
