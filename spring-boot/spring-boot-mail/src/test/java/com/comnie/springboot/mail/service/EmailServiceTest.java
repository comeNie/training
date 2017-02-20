package com.comnie.springboot.mail.service;

import com.comnie.springboot.mail.Application;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;

/**
 * Created by 波 on 2017/2/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class EmailServiceTest {
    @Autowired
    private EmailService emailService;

    private String to;

    private String subject;

    private String html;

    private String text;

    private File file;

    @Before
    public void setUp() throws Exception {
        to = "comenie@163.com";
        subject="测试邮件";
        html ="<html><head></head><body><h1>spring 邮件测试</h1><p>hello!this is spring mail test。</p></body></html>";
        text = "测试发送邮件-------";
        file = new File(this.getClass().getResource("/test.jpg").getFile());

    }

    @Test
    public void sendTextMail() throws Exception {
        emailService.sendTextMail(subject,text,to);
    }

    @Test
    public void sendHtmlMail() throws Exception {
       emailService.sendHtmlMail(subject,html,to);
    }

    @Test
    public void sendInlineImageMail() throws Exception {
        emailService.sendInlineImageMail(subject,text,new File[]{file},to);
    }

    @Test
    public void sendAttachmentFileMail() throws Exception {
        emailService.sendAttachmentFileMail(subject,text,new File[]{file},to);
    }

}