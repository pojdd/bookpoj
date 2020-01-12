package top.wangdfeng.bookserver.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.springframework.stereotype.Repository;
import top.wangdfeng.bookserver.dao.UserDao;
import top.wangdfeng.bookserver.entity.User;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Repository
public class UserDaoImpl implements UserDao {

    private static String SQL_INSERT;

    private static String SQL_QUERY;

    static {
        SQL_INSERT="insert into user values(?,?,?,?,?,?)";
        SQL_QUERY="select * from user where account=?";
    }

    @Resource
    private DataSource dataSource;

    @Override
    public int insertUser(User user) {
        Date date = new Date();//获得系统时间.
        SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );
        String nowTime = sdf.format(date);
        Date time=null;
        try {
            time = sdf.parse( nowTime );
        } catch (ParseException e) {
            e.printStackTrace();
        }
        QueryRunner queryRunner=new QueryRunner(dataSource);
        try {
            /*
             * 首先查询user.account是否存在，如果存在就返回0
             * 成功注册返回1
            * */
            if(queryUserExist(user.getAccount(),queryRunner)==null){
                queryRunner.update(SQL_INSERT,null,user.getAccount(),user.getPassword(),user.getEmail(),null,null);
                return 1;
            }else{
                return 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public User queryUserExist(String userAccount,QueryRunner queryRunner) {
         User user=null;
        try {
            user=queryRunner.query(SQL_QUERY,new BeanHandler<User>(User.class),userAccount);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

}
