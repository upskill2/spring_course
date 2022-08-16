package com.spring_intro;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test5InitDestroy {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationPropertiesSingletone.xml");

     Dog myDog =   context.getBean("myPet",Dog.class);
     myDog.say();

        Dog myDog1 =   context.getBean("myPet",Dog.class);
        myDog.say();

     context.close();

    }
}
