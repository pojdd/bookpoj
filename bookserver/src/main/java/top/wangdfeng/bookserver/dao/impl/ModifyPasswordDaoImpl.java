package top.wangdfeng.bookserver.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.springframework.stereotype.Repository;
import top.wangdfeng.bookserver.dao.ModifyPasswordDao;
import top.wangdfeng.bookserver.to.MdifiyTo;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;

@Repository
public class ModifyPasswordDaoImpl implements ModifyPasswordDao {

    @Resource
    private DataSource dataSource;

    private static String SQL;

    static{
        SQL="update user set password=? where account=?";
    }


    @Override
    public int ModifyPassword(MdifiyTo to) {
        QueryRunner queryRunner=new QueryRunner(dataSource);
        int row=0;
        try {
            row=queryRunner.update(SQL,to.getPassword(),to.getAccount());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }
}
