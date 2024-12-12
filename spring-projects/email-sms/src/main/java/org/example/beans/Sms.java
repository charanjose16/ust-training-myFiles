package org.example.beans;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class Sms {

    public void sendSms(String phnNo){
        System.out.println("""
                From : %s
                Message : [ Hello from charan ]
                
                """.formatted(phnNo));
    }
}
