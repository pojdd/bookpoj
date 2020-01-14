package top.wangdfeng.bookserver.service.impl;

import org.springframework.stereotype.Service;
import top.wangdfeng.bookserver.dao.ModifyPasswordDao;
import top.wangdfeng.bookserver.service.ModifyPasswordService;
import top.wangdfeng.bookserver.to.MdifiyTo;

import javax.annotation.Resource;

@Service
public class ModifyPasswordServiceImpl implements ModifyPasswordService {

    @Resource
    private ModifyPasswordDao dao;

    @Override
    public int modifyPasswordService(MdifiyTo to) {
        return dao.ModifyPassword(to);
    }
}
