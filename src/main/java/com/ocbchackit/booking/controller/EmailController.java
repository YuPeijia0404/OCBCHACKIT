package com.ocbchackit.booking.controller;


import com.ocbchackit.booking.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


@Controller
@RequestMapping(value = "/email")
public class EmailController {

    @Autowired
    JavaMailSender javaMailSender;
    String id;

    @ResponseBody
    @RequestMapping(value = "/id")
    public void receiveId(String id){
        this.id = id;
    }

    @ResponseBody
    @RequestMapping(value = "/send")
    public Result<?> sendEmail(String email, String username){
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        try {
            mimeMessageHelper.setSubject("Booking Successfully");
            mimeMessageHelper.setText(username +",your ticket booking is successful! Your seat number is: " + this.id);
            mimeMessageHelper.setFrom("yupeijia20010404@163.com");
            mimeMessageHelper.setTo(email);
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return Result.success();
    }


}
