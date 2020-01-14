package top.wangdfeng.bookserver.service.impl;

import org.springframework.stereotype.Service;
import top.wangdfeng.bookserver.dao.BookSerachDao;
import top.wangdfeng.bookserver.to.SerachKey;
import top.wangdfeng.bookserver.service.SerachService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SerachServiceImpl implements SerachService {
    @Resource
    private BookSerachDao bookSerachDao;
    @Override
    public List<SerachKey> Serach(String key) {
        return bookSerachDao.Serach(key);
    }
}
