package top.wangdfeng.bookserver.dao;

import org.springframework.stereotype.Repository;
import top.wangdfeng.bookserver.entity.Chapter;

import java.util.List;

public interface ChapterDao {
    List<Chapter> getChapters(String bookid);
}
