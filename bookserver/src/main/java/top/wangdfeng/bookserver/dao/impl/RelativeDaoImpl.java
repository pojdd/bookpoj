package top.wangdfeng.bookserver.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.stereotype.Repository;
import top.wangdfeng.bookserver.dao.RelativeDao;
import top.wangdfeng.bookserver.entity.Book;

import javax.annotation.Resource;
import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RelativeDaoImpl implements RelativeDao {

    @Resource
    private DataSource dataSource;

    private static String SQL="select * from book where bookclass=?";

    @Override
    public List<Book> getRelative(String classes) {
        System.out.println(classes);
        classes="["+classes+"]";
        QueryRunner queryRunner=new QueryRunner(dataSource);
        List<Book> books=null;
        List<Book> newbook=new ArrayList<Book>();
        int num=1;
        try {
            books=queryRunner.query(SQL,new BeanListHandler<Book>(Book.class),classes);
            for(int i=1;i<=6;i++){
                newbook.add(books.get(i));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newbook;
    }
}
