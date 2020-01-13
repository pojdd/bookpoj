package top.wangdfeng.bookserver.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.stereotype.Repository;
import top.wangdfeng.bookserver.dao.ChapterDao;
import top.wangdfeng.bookserver.entity.Chapter;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ChapterDaoImpl implements ChapterDao {

    private static String SQL="select * from bookcontent where bookid=?";

    @Resource
    private DataSource source;

    @Override
    public List<Chapter> getChapters(String bookid) {
        QueryRunner queryRunner=new QueryRunner(source);
        List<Chapter> lists=null;
        try {
            lists=queryRunner.query(SQL,new BeanListHandler<Chapter>(Chapter.class),bookid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("数据为"+lists.size());
        return lists;
    }
}
