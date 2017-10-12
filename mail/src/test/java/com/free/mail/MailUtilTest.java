package com.free.mail;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Date 2017/10/12 16:23
 * Description:
 */
public class MailUtilTest {

    @Test
    public void sendMail() throws Exception {
        MailUtil.sendMail("测试邮件");

    }

}