package com.free.mail;

import javax.mail.*;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
  
/** 
 * 发送邮件的测试程序 
 *  
 *  
 */  
public class MailUtil {

    public static void main(String[] args) {
        sendMail("ceshi");
    }

	public static void sendMail(String msg) {
		// 配置发送邮件的环境属性
        final Properties props = new Properties();  
        // 表示SMTP发送邮件，需要进行身份验证  
        props.setProperty("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", "smtp.qq.com");  
        props.put("mail.smtp.auth", "true");  
        // 发件人的账号  
        props.put("mail.user", "7394728161111@qq.com");
        // 访问SMTP服务时需要提供的密码  
        props.put("mail.password", "xpxipcqxulujbegg");  
        props.setProperty("mail.debug", "true");
        props.put("mail.smtp.port","465");
        props.put("mail.smtp.ssl.enable","true");
        // 构建授权信息，用于进行SMTP进行身份验证  
        Authenticator authenticator = new Authenticator() {  
            @Override  
            protected PasswordAuthentication getPasswordAuthentication() {  
                // 用户名、密码  
                String userName = props.getProperty("mail.user");  
                String password = props.getProperty("mail.password");  
                return new PasswordAuthentication(userName, password);  
            }  
        };  
        // 使用环境属性和授权信息，创建邮件会话  
        Session mailSession = Session.getInstance(props, authenticator);  
        // 创建邮件消息  
        MimeMessage message = new MimeMessage(mailSession);  
        
        try {
	        // 设置发件人  
	        InternetAddress form = new InternetAddress(props.getProperty("mail.user"));  
	        message.setFrom(form);  
	        
	        // 设置收件人  
	        InternetAddress to = new InternetAddress("2213883630@qq.com");
	        message.setRecipient(RecipientType.TO, to);  
	  
	//        // 设置抄送  
	//        InternetAddress cc = new InternetAddress("2213883630@qq.com");  
	//        message.setRecipient(RecipientType.CC, cc);  
	//  
	//        // 设置密送，其他的收件人不能看到密送的邮件地址  
	//        InternetAddress bcc = new InternetAddress("2213883630@qq.com");  
	//        message.setRecipient(RecipientType.CC, bcc);  
	  
	        // 设置邮件标题  
	       
			message.setSubject("邮件测试主题");
			
	  
	        // 设置邮件的内容体  
	        message.setContent("<a href='http://sd.sunnyfree.com'>邮件测试。</a>"+getTime()+"<br>"+msg, "text/html;charset=UTF-8");
	        // 发送邮件
	        Transport.send(message);  
        
        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("发送失败wwwwwwwwwwwwwwww");

        }
		
	}

	private static String getTime() {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(new Date());
	} 
    
}  