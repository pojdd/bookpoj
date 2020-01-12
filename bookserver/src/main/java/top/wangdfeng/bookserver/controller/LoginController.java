package top.wangdfeng.bookserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.wangdfeng.bookserver.entity.User;
import top.wangdfeng.bookserver.service.LoginService;
import top.wangdfeng.bookserver.to.AP;

import javax.annotation.Resource;

@RestController
public class LoginController {
    @Resource
    private LoginService loginService;

    @RequestMapping("/login")
    public User login(AP ap){
        return loginService.login(ap);
    }
}
