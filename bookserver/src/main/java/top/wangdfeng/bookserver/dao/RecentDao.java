package top.wangdfeng.bookserver.dao;

import javax.annotation.Resource;
import javax.sql.DataSource;

public interface RecentDao {
    void setRecentTime(DataSource dataSource,String account);
}
