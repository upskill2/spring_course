package com.spring_intro;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test3 {

    public static void main(String[] args) {

    //    Pet pet = new Cat();

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationProperties.xml");

    //  Pet pet =   context.getBean("myPet",Pet.class);

        Person person = context.getBean("myPerson",Person.class);
        person.callYouPet();

        System.out.println(person.getSurname());
        System.out.println(person.getAge());

    }
}
