package top.wangdfeng.bookserver.service.impl;

import org.springframework.stereotype.Service;
import top.wangdfeng.bookserver.dao.BookSheltAddDao;
import top.wangdfeng.bookserver.entity.BookShelf;
import top.wangdfeng.bookserver.service.BookShelfAddService;

import javax.annotation.Resource;

@Service
public class BookShelfAddServiceImpl  implements BookShelfAddService {

    @Resource
    private BookSheltAddDao sheltAddDao;

    @Override
    public int add(BookShelf shelf) {
        return sheltAddDao.add(shelf);
    }
}
