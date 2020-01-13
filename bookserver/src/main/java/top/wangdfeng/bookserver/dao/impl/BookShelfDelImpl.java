package top.wangdfeng.bookserver.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.springframework.stereotype.Repository;
import top.wangdfeng.bookserver.dao.BookShelfDelDao;
import top.wangdfeng.bookserver.entity.BookShelf;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;

@Repository
public class BookShelfDelImpl implements BookShelfDelDao {

    private static String SQL_DELETE;

    static{
        SQL_DELETE="delete from  bookshelf where userid=? and bookid=?";
    }

    @Resource
    private DataSource source;

    @Override
    public int delete(BookShelf shelf) {
        System.out.println("Dao"+shelf.toString());
        QueryRunner queryRunner=new QueryRunner(source);
        int row=1;
        try {
            row=queryRunner.update(SQL_DELETE,shelf.getUserid(),shelf.getBookid());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }
}
