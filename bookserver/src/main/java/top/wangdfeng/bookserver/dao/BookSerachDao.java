package top.wangdfeng.bookserver.dao;

import top.wangdfeng.bookserver.to.SerachKey;

import java.util.List;

public interface BookSerachDao {
    List<SerachKey> Serach(String key);
}
