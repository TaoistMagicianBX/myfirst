package cn.usian.controller;

import cn.usian.App;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {App.class})
public class testemailController {

    @Autowired
    private JavaMailSender javaMailSender;


    @Test
    public void testSend() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("2012122100@qq.com");
        message.setTo("2317183068@qq.com");
        message.setSubject("这是标题");
        message.setText("这是内容");
        javaMailSender.send(message);
    }
}
