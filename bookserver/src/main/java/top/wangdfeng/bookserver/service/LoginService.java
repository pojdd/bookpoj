package top.wangdfeng.bookserver.service;

import org.springframework.stereotype.Service;
import top.wangdfeng.bookserver.entity.User;
import top.wangdfeng.bookserver.to.AP;

public interface LoginService {
    User login(AP ap);
}
