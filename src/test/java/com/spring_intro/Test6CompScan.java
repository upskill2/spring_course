package com.spring_intro;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test6CompScan {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationPropertiesCompScan.xml");

        Person person = context.getBean("person", Person.class);

        person.callYouPet();

        System.out.println(person.getAge());
        System.out.println(person.getSurname());
    }
}
