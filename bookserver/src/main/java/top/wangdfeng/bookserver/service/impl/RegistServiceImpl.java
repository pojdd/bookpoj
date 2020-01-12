package top.wangdfeng.bookserver.service.impl;

import org.springframework.stereotype.Service;
import top.wangdfeng.bookserver.dao.UserDao;
import top.wangdfeng.bookserver.entity.User;
import top.wangdfeng.bookserver.service.RegistService;

import javax.annotation.Resource;

@Service
public class RegistServiceImpl  implements RegistService {

    @Resource
    private UserDao userDao;
    @Override
    public int attemptReg(User user) {
        return userDao.insertUser(user);
    }
}
