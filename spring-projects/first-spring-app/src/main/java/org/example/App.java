package org.example;

import org.example.beans.Phone;
import org.example.beans.Sim;
import org.example.configuration.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App 
{
    public static void main( String[] args )
    {

        ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
        Phone phone=context.getBean(Phone.class);
        String phnNo="7358425020";
        phone.call(phnNo);
        phone.sendText(phnNo,"Hello....When are you reaching?");
    }
}
