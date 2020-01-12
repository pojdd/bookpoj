package top.wangdfeng.bookserver.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.springframework.stereotype.Repository;
import top.wangdfeng.bookserver.dao.LoginDao;
import top.wangdfeng.bookserver.entity.User;
import top.wangdfeng.bookserver.to.AP;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;

@Repository
public class LoginDaoImpl implements LoginDao {

    private static String SQL_LOGIN;

    static{
        SQL_LOGIN="select * from user where account=?";
    }

    @Resource
    private DataSource dataSource;

    @Override
    public User login(AP ap) {
        System.out.println(ap.getAccount());
        QueryRunner queryRunner=new QueryRunner(dataSource);
        try {
            User user =queryRunner.query(SQL_LOGIN,new BeanHandler<User>(User.class),ap.getAccount());
            if(user==null){
                return null;
            }else{
                if(user.getPassword().equals(ap.getPassword())){
                    //成功登录
                    RecentDaoImpl recentDao=new RecentDaoImpl();
                    recentDao.setRecentTime(dataSource,user.getAccount());
                    return user;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
