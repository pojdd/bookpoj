package top.wangdfeng.bookserver.service.impl;

import org.springframework.stereotype.Service;
import top.wangdfeng.bookserver.dao.ChapterDao;
import top.wangdfeng.bookserver.entity.Chapter;
import top.wangdfeng.bookserver.service.ChapterService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ChapterServiceImpl implements ChapterService {

    @Resource
    private ChapterDao chapterDao;

    @Override
    public List<Chapter> getChapters(String bookid) {
        return chapterDao.getChapters(bookid);
    }
}
