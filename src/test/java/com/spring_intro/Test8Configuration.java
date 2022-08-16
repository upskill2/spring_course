package com.spring_intro;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test8Configuration {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

/*        Pet cat = context.getBean("catBean", Cat.class);
        Pet cat1 = context.getBean("catBean", Cat.class);
        cat.say();*/

        Person person = context.getBean("personBean", Person.class);
        person.callYouPet();

        System.out.println(person.getAge());
        System.out.println(person.getSurname());

    }
}
