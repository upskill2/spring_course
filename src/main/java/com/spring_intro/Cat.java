package com.spring_intro;

import org.springframework.stereotype.Component;

//@Component
public class Cat implements Pet {


    public Cat() {
        System.out.println("Cat class created");
    }

    @Override
    public void say() {
        System.out.println("Meow-Meow");
    }
}
