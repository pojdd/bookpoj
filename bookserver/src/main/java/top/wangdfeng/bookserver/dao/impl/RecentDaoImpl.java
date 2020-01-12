package top.wangdfeng.bookserver.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.springframework.stereotype.Repository;
import top.wangdfeng.bookserver.dao.RecentDao;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Repository
public class RecentDaoImpl implements RecentDao {

    private static String SQL;

    static{
        SQL="update user set recentime=? where account=?";
    }



    @Override
    public void setRecentTime(DataSource source,String account)  {
        Date date = new Date();//获得系统时间.
        SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );
        String nowTime = sdf.format(date);
        Date time=null;
        try {
            time = sdf.parse( nowTime );
        } catch (ParseException e) {
            e.printStackTrace();
        }
        QueryRunner queryRunner=new QueryRunner(source);
        try {
            queryRunner.update(SQL,time,account);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
