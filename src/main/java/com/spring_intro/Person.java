package com.spring_intro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component
public class Person {

/*    @Autowired
    @Qualifier("cat")*/
    private Pet pet;
    @Value("${person.surname}")
    private String surname;
    @Value("${person.age}")
    private int age;

    //args constructor
  //  @Autowired

    public Person(Pet pet) {
        System.out.println("Person Bean created");
        this.pet = pet;
    }
/*    public Person() {
        System.out.println("Person Bean created");
    }*/

    public void callYouPet() {
        System.out.println("Calling a pet");
        pet.say();
    }

  //  @Autowired
 //   @Qualifier("cat")
    public void setPet(Pet pet) {
        System.out.println("Calling setter in Person.class");

        this.pet = pet;
    }

    public String getSurname() {
        System.out.println("Calling getSurname in Person.class.");
        return surname;
    }

    public void setSurname(String surname) {
        System.out.println("Setting surname");
        this.surname = surname;
    }

    public int getAge() {
        System.out.println("Calling getAge in Person.class");
        return age;
    }

    public void setAge(int age) {
        System.out.println("Setting age");
        this.age = age;
    }
}
