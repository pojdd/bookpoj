package top.wangdfeng.bookserver.dao;

import org.apache.commons.dbutils.QueryRunner;
import top.wangdfeng.bookserver.entity.User;

public interface UserDao {
    int insertUser(User user);
    User queryUserExist(String userAccount, QueryRunner queryRunner);
}
