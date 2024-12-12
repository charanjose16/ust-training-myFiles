package org.example.service;

import org.example.beans.Email;
import org.example.beans.Sms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class NotificationImpl implements Notification{
    @Autowired
    Sms sms;

    @Autowired
    Email email;
    public void SendASms(String mailId) {

        System.out.println("SMS Received");
        email.sendEmail(mailId);
    }

    public void SendAnEmail(String phnNo) {
        System.out.println("Email Received");
        sms.sendSms(phnNo);
    }
}
