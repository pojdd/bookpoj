package top.wangdfeng.bookserver.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.springframework.stereotype.Repository;
import top.wangdfeng.bookserver.dao.VertifyBookStateDao;
import top.wangdfeng.bookserver.entity.BookShelf;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;

@Repository
public class VertifyBookStateDaoImpl implements VertifyBookStateDao {

    @Resource
    private DataSource dataSource;

    private static String SQL;

    static{
        SQL="select * from bookshelf where userid=? and bookid=?";
    }

    @Override
    public boolean vertify(BookShelf shelf) {
        QueryRunner queryRunner=new QueryRunner(dataSource);
        boolean flag=false;
        try {
            BookShelf shelf1=queryRunner.query(SQL,new BeanHandler<BookShelf>(BookShelf.class),shelf.getUserid(),shelf.getBookid());
            if(shelf1==null){
                flag=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(shelf.toString());
        return flag;
    }
}
