package top.wangdfeng.bookserver.service.impl;

import org.springframework.stereotype.Service;
import top.wangdfeng.bookserver.dao.BookshelfDao;
import top.wangdfeng.bookserver.entity.Book;
import top.wangdfeng.bookserver.service.BookshelfService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookshelfServiceImpl  implements BookshelfService {

    @Resource
    private BookshelfDao bookshelfDao;

    @Override
    public List<Book> getUserBookShelf(String userid) {
        System.out.println("userid为:"+userid);
        return bookshelfDao.queryBooksByUserId(userid);
    }
}
