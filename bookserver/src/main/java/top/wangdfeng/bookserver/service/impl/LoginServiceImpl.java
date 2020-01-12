package top.wangdfeng.bookserver.service.impl;

import org.springframework.stereotype.Service;
import top.wangdfeng.bookserver.dao.LoginDao;
import top.wangdfeng.bookserver.entity.User;
import top.wangdfeng.bookserver.service.LoginService;
import top.wangdfeng.bookserver.to.AP;

import javax.annotation.Resource;

@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private LoginDao loginDao;

    @Override
    public User login(AP ap) {
        System.out.println("ap:"+ap.toString());
        loginDao.login(ap);
        return null;
    }
}
