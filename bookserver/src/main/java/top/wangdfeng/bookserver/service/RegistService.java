package top.wangdfeng.bookserver.service;

import top.wangdfeng.bookserver.entity.User;

public interface RegistService {
    int attemptReg(User user) throws Exception;

    int Reg(String url);
}
