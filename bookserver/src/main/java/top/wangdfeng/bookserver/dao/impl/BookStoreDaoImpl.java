package top.wangdfeng.bookserver.dao.impl;

import org.apache.catalina.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.stereotype.Repository;
import top.wangdfeng.bookserver.dao.BookStoreDao;
import top.wangdfeng.bookserver.entity.Book;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BookStoreDaoImpl implements BookStoreDao {

    @Resource
    private DataSource dataSource;

    private static String SQL;

    static {
        SQL="select * from book order by readcount DESC";
    }

    @Override
    public List queryBook() {
        QueryRunner queryRunner=new QueryRunner(dataSource);
        try {
            List<Book> list=queryRunner.query(SQL,new BeanListHandler<Book>(Book.class));
            for (Book book:list
                 ) {
                book.setShortsummry(book.getSummry().substring(0,13)+"...");
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
