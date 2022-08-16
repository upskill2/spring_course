package com.spring_intro;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test7Scope {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationPropertiesCompScan.xml");

        Dog dog1 = context.getBean("dog", Dog.class);
        Dog dog2 = context.getBean("dog", Dog.class);

        dog1.say();

        /*
        System.out.println(dog1);
        System.out.println(dog2);*/

        context.close();

    }
}
