package top.wangdfeng.bookserver.utils;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class SendMail {
    public static String myEmailAccount = "wdf2353829347@163.com";
    public static String myEmailPassword = "wdf1997";
    public static String myEmailSMTPHost = "smtp.163.com";
    public static void send(String  receiveMailAccount,String url) throws Exception {
        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.smtp.host", myEmailSMTPHost);
        props.setProperty("mail.smtp.auth", "true");
        Session session = Session.getInstance(props);
        session.setDebug(false);
        MimeMessage message = createMimeMessage(session, myEmailAccount, receiveMailAccount,url);
        Transport transport = session.getTransport();
        transport.connect(myEmailAccount, myEmailPassword);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }

    public static MimeMessage createMimeMessage(Session session, String sendMail, String receiveMail,String url)
            throws Exception {
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(sendMail, "BookProject", "UTF-8"));
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, "XX用户", "UTF-8"));
        message.setSubject("登录验证", "UTF-8");
        message.setContent("<html>\n" +
                "\t<head>\n" +
                "\t\t<meta charset=\"utf-8\">\n" +
                "\t\t<title></title>\n" +
                "\t</head>\n" +
                "\t<body>\n" +
                "\t\t<h3>您好:</h3>\n" +
                "\t\t<p>欢迎您注册本微信小程序，点击链接完成注册验证</p>\n" +
                "\t\t<a href=\""+url+"\">请点击这里验证</a>\n" +
                "\t"+url+"\n"+
                "\t</body>\n" +
                "</html>\n", "text/html;charset=UTF-8");
        message.setSentDate(new Date());
        message.saveChanges();
        return message;
    }
}
