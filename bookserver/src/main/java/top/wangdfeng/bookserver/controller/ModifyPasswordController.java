package top.wangdfeng.bookserver.controller;

import org.apache.commons.dbutils.QueryRunner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.wangdfeng.bookserver.service.ModifyPasswordService;
import top.wangdfeng.bookserver.to.MdifiyTo;

import javax.annotation.Resource;

@RestController
public class ModifyPasswordController {

    @Resource
    private ModifyPasswordService modifyPasswordService;


    @RequestMapping("/modify_password")
    public int modifyPassword(MdifiyTo mdifiyTo){
        return modifyPasswordService.modifyPasswordService(mdifiyTo);
    }
}
