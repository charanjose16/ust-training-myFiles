package org.example.beans;

import org.springframework.stereotype.Component;

@Component
public class Email {

    public void sendEmail(String mailId){

        System.out.println("""
                From: %s
                Message : [ Hello from charan ]
                
                """.formatted(mailId));
    }
}
