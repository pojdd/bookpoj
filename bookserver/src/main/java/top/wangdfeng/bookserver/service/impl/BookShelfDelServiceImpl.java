package top.wangdfeng.bookserver.service.impl;

import org.springframework.stereotype.Service;
import top.wangdfeng.bookserver.dao.BookShelfDelDao;
import top.wangdfeng.bookserver.entity.BookShelf;
import top.wangdfeng.bookserver.service.BookShelfDelService;

import javax.annotation.Resource;

@Service
public class BookShelfDelServiceImpl implements BookShelfDelService {

    @Resource
    private BookShelfDelDao bookShelfDelDao;


    @Override
    public int delete(BookShelf bookShelf) {
        return bookShelfDelDao.delete(bookShelf);
    }
}
