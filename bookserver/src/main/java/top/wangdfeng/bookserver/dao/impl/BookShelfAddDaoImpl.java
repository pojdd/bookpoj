package top.wangdfeng.bookserver.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.springframework.stereotype.Repository;
import top.wangdfeng.bookserver.dao.BookSheltAddDao;
import top.wangdfeng.bookserver.dao.BookshelfDao;
import top.wangdfeng.bookserver.entity.BookShelf;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;

@Repository
public class BookShelfAddDaoImpl implements BookSheltAddDao {

    @Resource
    private DataSource dataSource;

    private static String SQL_ADD;

    static{
        SQL_ADD="insert into bookshelf values(?,?)";
    }

    @Override
    public int add(BookShelf bookShelf) {
        QueryRunner queryRunner=new QueryRunner(dataSource);
        int result=0;
        try {
            result=queryRunner.update(SQL_ADD,bookShelf.getBookid(),bookShelf.getUserid());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
