package top.wangdfeng.bookserver.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.stereotype.Repository;
import top.wangdfeng.bookserver.dao.BookshelfDao;
import top.wangdfeng.bookserver.entity.Book;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BookshelfDaoImpl  implements BookshelfDao {

    private static String SQL_MUTI;

    static{
        SQL_MUTI="select * from bookshelf " +
                "left join book on bookshelf.bookid=book.bookid" +
                " where bookshelf.userid=?";
    }

    @Resource
    private DataSource dataSource;

    @Override
    public List<Book> queryBooksByUserId(String userid) {
        //dao层成功获取userid
        QueryRunner queryRunner=new QueryRunner(dataSource);
        List<Book> shelfbooks= null;
        try {
            shelfbooks = queryRunner.query(SQL_MUTI,new BeanListHandler<Book>(Book.class),userid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shelfbooks;
    }
}
