package com.spring_intro;

public class Person {

    private Pet pet;



/*    public Person(Pet pet) {
        System.out.println("Person Bean created");
        this.pet = pet;
    }*/

    public Person() {
        System.out.println("Person Bean created");
    }

    public void callYouPet(){
        System.out.println("Calling a pet");

        pet.say();
    }

    public void setPet(Pet pet) {
        System.out.println("Calling setter in Person.class");

        this.pet = pet;
    }

}
