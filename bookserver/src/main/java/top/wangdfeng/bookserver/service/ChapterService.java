package top.wangdfeng.bookserver.service;

import top.wangdfeng.bookserver.entity.Chapter;

import java.util.List;

public interface ChapterService {
    List<Chapter> getChapters(String bookid);
}
