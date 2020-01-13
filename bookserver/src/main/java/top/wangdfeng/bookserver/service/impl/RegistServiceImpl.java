package top.wangdfeng.bookserver.service.impl;

import org.springframework.stereotype.Service;
import top.wangdfeng.bookserver.dao.UserDao;
import top.wangdfeng.bookserver.entity.User;
import top.wangdfeng.bookserver.service.RegistService;
import top.wangdfeng.bookserver.utils.SendMail;
import org.pojdd.tools.registerInfo;
import javax.annotation.Resource;
import org.pojdd.tools.registerInfo;
@Service
public class RegistServiceImpl  implements RegistService {
    @Resource
    private UserDao userDao;
    @Override
    public int attemptReg(User user) throws Exception {
        String url=registerInfo.generateUrl(user);
        url="http://localhost:8080/registS?url="+url;
        SendMail.send(user.getEmail(),url);
        return 1;
    }

    /***
     *
     * @param url 加密参数
     * @return -1表示链接失效
     */
    @Override
    public int Reg(String url) {
        User user=registerInfo.testUrl(url,600000);
        if(user==null){
            return -1;
        }
        return userDao.insertUser(user);
    }
}
