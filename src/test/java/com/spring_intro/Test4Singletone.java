package com.spring_intro;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test4Singletone {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationPropertiesSingletone.xml");


/*        Dog dog1 = context.getBean("myPet", Dog.class);
        dog1.setName("qwert");

        Dog dog2 = context.getBean("myPet", Dog.class);
        dog2.setName("wsds");

        System.out.println(dog1.getName());
        System.out.println(dog2.getName());*/

        /*
        System.out.println(dog1==dog2);

        System.out.println(dog1);
        System.out.println(dog2);*/
    }
}
