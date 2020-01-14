package top.wangdfeng.bookserver.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.stereotype.Repository;
import top.wangdfeng.bookserver.dao.GetBookbyIdDao;
import top.wangdfeng.bookserver.entity.Book;
import top.wangdfeng.bookserver.entity.SerachKey;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@Repository
public class GetBookbyIdDaoImpl implements GetBookbyIdDao {
    private final static String GetBookSql="SELECT * FROM book WHERE bookid = ?";

    @Resource
    private DataSource dataSource;

    @Override
    public Book getBookById(String id) {
        System.out.println("id="+id);
        QueryRunner queryRunner=new QueryRunner(dataSource);
        try {
            Book book=queryRunner.query(GetBookSql,new BeanHandler<>(Book.class),id);
            book.setShortsummry(book.getSummry().substring(0,13)+"...");
            System.out.println(book);
            return book;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
