package org.pojdd.tools;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import top.wangdfeng.bookserver.entity.User;

import java.util.Date;

public class registerInfo {
    public static boolean wait;
    public static String solt="Vx.((O.o))~hi|__everybody";//固定盐应该保密

    /***
     *
     * @param user 注册用户
     * @return 返回url
     */
    public static String generateUrl(User user){
        Date d1=new Date();
        JSONObject json = new JSONObject();
        json.put("account",user.getAccount());
        json.put("password",user.getPassword());
        json.put("email",user.getEmail());
        json.put("time",d1.getTime());
        json.put("digest",
                MD5.encode(user.getAccount()+user.getPassword()+user.getEmail()+d1.getTime()+solt).substring(1,8));
        //信息摘要用于验证信息是否被修改
        AESUtil.setKEY(solt);
        String url=AESUtil.encrypt(json.toJSONString());
        return url;
    }

    /***
     *
     * @param url 加密参数
     * @param timeout 超时时间,单位毫秒
     * @return 如果User有效则返回，否则返回NULL
     */
    public static User testUrl(String url,long timeout){//返回信息是否失效
        Date d1=new Date();
        AESUtil.setKEY(solt);
        url=AESUtil.decrypt(url);
//        System.out.println(url);
        if (url.equals("error"))
            return null;
        JSONObject json=JSON.parseObject(url);
        String digest = json.getString("digest");
        String account =json.getString("account");
        String password =json.getString("password");
        String email =json.getString("email");
        String time =json.getString("time");
        String digest1 = MD5.encode(account+password+email+time+solt).substring(1,8);
        if(!digest.equals(digest1))
            return null;
        if (d1.getTime()- Long.parseLong(time)>timeout)
            return null;
        User user=new User();
        user.setAccount(account);
        user.setPassword(password);
        user.setEmail(email);
        return user;
    }

    //测试函数有效性
    public static void main(String[] args) {
//        System.out.println(MD5.encode("ddd"));
        User user=new User();
        user.setAccount("123cvffffaa");
        user.setPassword("q1111asfas1");
        user.setEmail("pojdd@qq.com");
        String url=registerInfo.generateUrl(user);
        System.out.println(url);

        //如果延迟2秒则失效
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        user.setPassword("1111asfas1");
        User u= registerInfo.testUrl(url,1000);
        if(u==null)
            System.out.println("失效");
        else
            System.out.println(u);
    }
}
