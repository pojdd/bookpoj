package top.wangdfeng.bookserver.service.impl;

import org.springframework.stereotype.Service;
import top.wangdfeng.bookserver.dao.UserDao;
import top.wangdfeng.bookserver.entity.User;
import top.wangdfeng.bookserver.service.RegistService;
import top.wangdfeng.bookserver.utils.SendMail;

import javax.annotation.Resource;

@Service
public class RegistServiceImpl  implements RegistService {

    @Resource
    private UserDao userDao;
    @Override
    public int attemptReg(User user) throws Exception {
        SendMail.send(user.getEmail());
        return userDao.insertUser(user);
    }
}
