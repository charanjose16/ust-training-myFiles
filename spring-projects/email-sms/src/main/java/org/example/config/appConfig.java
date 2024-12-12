package org.example.config;

import org.example.service.NotificationImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@ComponentScan("org.example")
@PropertySource("application.properties")
public class appConfig {


}
