package com.web.www.util;

import com.web.www.entity.HelloWorld;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppMain {

//Test for helloworld bean
    public static void main(String args[]){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-ioc.xml");
        HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld");
        helloWorld.setMessage("Message from set");
        helloWorld.printMessage();

    }


}


