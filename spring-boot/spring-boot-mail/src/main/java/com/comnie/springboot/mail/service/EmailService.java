package com.comnie.springboot.mail.service;

import com.google.common.base.Charsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Created by 波 on 2017/2/20.
 */
@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String  from;

    public void sendTextMail(String subject,String text,String ... to) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(to);
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(text);
        mailSender.send(simpleMailMessage);
    }

    public void sendHtmlMail(String subject,String html,String ... to) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setFrom(from);
        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setText(html,true);
        mailSender.send(mimeMessage);
    }

    public void sendInlineImageMail(String subject,String text,File[] inlineImages,String ... to) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true, Charsets.UTF_8.name());
        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setFrom(from);
        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setText(text);
        for(File file : inlineImages){
            mimeMessageHelper.addInline(file.getName(),file);
        }
        mailSender.send(mimeMessage);

    }

    public void sendAttachmentFileMail(String subject,String text,File[] attachments,String ... to) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true, Charsets.UTF_8.name());
        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setFrom(from);
        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setText(text);
        for(File file : attachments){
            mimeMessageHelper.addAttachment(file.getName(),file);
        }
        mailSender.send(mimeMessage);

    }
}
