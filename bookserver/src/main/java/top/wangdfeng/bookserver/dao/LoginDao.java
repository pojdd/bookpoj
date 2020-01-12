package top.wangdfeng.bookserver.dao;

import org.springframework.stereotype.Repository;
import top.wangdfeng.bookserver.entity.User;
import top.wangdfeng.bookserver.to.AP;


public interface LoginDao {
    User login(AP ap);
}
