package top.wangdfeng.bookserver.dao;

import top.wangdfeng.bookserver.entity.SerachKey;

import java.util.List;

public interface BookSerachDao {
    List<SerachKey> Serach(String key);
}
