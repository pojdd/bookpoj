package top.wangdfeng.bookserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.wangdfeng.bookserver.entity.User;
import top.wangdfeng.bookserver.service.RegistService;

import javax.annotation.Resource;
import org.pojdd.tools.registerInfo;
@RestController
public class RegisterController {

    @Resource
    private RegistService registService;

    /**/

    @RequestMapping("/regist")
    public int regac(User user) throws Exception {
        return registService.attemptReg(user);//一般会返回1
    }


    @RequestMapping("/registS")
    public String registConfirm(String url){
//        System.out.println(url);
        int code=registService.Reg(url);
        if(code==-1)
            return "注册失败,链接已经失效了！";
        if(code==0)
            return "注册失败,该邮箱已经被注册了！";
        //http://localhost:8080/registS?url=%22ddd%22
        return "注册成功快去登录吧!";
    }
}
