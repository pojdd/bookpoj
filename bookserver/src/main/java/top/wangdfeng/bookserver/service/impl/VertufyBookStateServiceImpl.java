package top.wangdfeng.bookserver.service.impl;

import org.springframework.stereotype.Service;
import top.wangdfeng.bookserver.dao.VertifyBookStateDao;
import top.wangdfeng.bookserver.entity.BookShelf;
import top.wangdfeng.bookserver.service.VertufyBookStateService;

import javax.annotation.Resource;

@Service
public class VertufyBookStateServiceImpl implements VertufyBookStateService {

    @Resource
    private VertifyBookStateDao vertifyBookStateDao;

    @Override
    public boolean verity(BookShelf bookShelf) {
        return vertifyBookStateDao.vertify(bookShelf);
    }
}
