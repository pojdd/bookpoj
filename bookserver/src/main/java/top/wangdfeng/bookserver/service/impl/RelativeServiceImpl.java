package top.wangdfeng.bookserver.service.impl;

import org.springframework.stereotype.Service;
import top.wangdfeng.bookserver.dao.RelativeDao;
import top.wangdfeng.bookserver.entity.Book;
import top.wangdfeng.bookserver.service.RelativeService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RelativeServiceImpl implements RelativeService {

    @Resource
    private RelativeDao dao;

    @Override
    public List<Book> getRelative(String classes) {
        return dao.getRelative(classes);
    }
}
