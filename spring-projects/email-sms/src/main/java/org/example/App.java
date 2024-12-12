package org.example;

import org.example.beans.Phone;
import org.example.config.appConfig;
import org.example.service.Notification;
import org.example.service.NotificationImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context=new AnnotationConfigApplicationContext(appConfig.class);
        Notification notification=context.getBean(NotificationImpl.class);
        Phone phone = context.getBean(Phone.class);
        System.out.println(phone);
        notification.SendAnEmail("charanjoseph00@gmail.com");
        notification.SendASms("7358425020");

    }
}
