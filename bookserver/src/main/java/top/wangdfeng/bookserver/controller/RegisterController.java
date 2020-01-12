package top.wangdfeng.bookserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.wangdfeng.bookserver.entity.User;
import top.wangdfeng.bookserver.service.RegistService;

import javax.annotation.Resource;

@RestController
public class RegisterController {

    @Resource
    private RegistService registService;

    /**/

    @RequestMapping("/regist")
    public int regac(User user){
        return registService.attemptReg(user);
    }
}
