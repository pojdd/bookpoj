package top.wangdfeng.bookserver.service.impl;

import org.springframework.stereotype.Service;
import top.wangdfeng.bookserver.dao.GetBookbyIdDao;
import top.wangdfeng.bookserver.entity.Book;
import top.wangdfeng.bookserver.service.GetBookService;

import javax.annotation.Resource;

@Service
public class GetBookServiceImpl implements GetBookService {
    @Resource
    GetBookbyIdDao getBookbyIdDao;
    @Override
    public Book GetBookbyId(String bookid) {
        return getBookbyIdDao.getBookById(bookid);
    }
}
