package top.wangdfeng.bookserver.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.stereotype.Repository;
import top.wangdfeng.bookserver.dao.BookSerachDao;
import top.wangdfeng.bookserver.to.SerachKey;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BookSerachDaoImpl implements BookSerachDao {
    @Resource
    private DataSource dataSource;

    private static String SQL_Serach;

    static{
        SQL_Serach="SELECT bookid,bookname FROM book WHERE bookname LIKE ";
    }

    @Override
    public List<SerachKey> Serach(String key) {
        QueryRunner queryRunner=new QueryRunner(dataSource);
        try {
            String sql=SQL_Serach+"'%"+key+"%' LIMIT 0,5";
            List<SerachKey> list=queryRunner.query(sql,new BeanListHandler<SerachKey>(SerachKey.class));
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
