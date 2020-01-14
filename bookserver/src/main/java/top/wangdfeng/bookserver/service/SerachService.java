package top.wangdfeng.bookserver.service;

import top.wangdfeng.bookserver.to.SerachKey;

import java.util.List;

public interface SerachService {
    List<SerachKey> Serach(String key) ;
}
