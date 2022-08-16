package com.spring_intro;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Component
@Scope("singleton")
public class Dog implements Pet {

    public Dog() {
        System.out.println("Dog Bean created");
    }

    /*private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }*/

    @PostConstruct
    protected void init(){
        System.out.println("Init method called");
    }

    @PreDestroy
    private void destroy(){

        System.out.println("Destroy method called");
    }

    @Override
    public void say(){

        System.out.println("Bow-Wow");
    }
}
