package com.spring_intro;

import org.springframework.context.annotation.*;

@Configuration
@PropertySource("app.properties")
//@ComponentScan("com.spring_intro")
public class MyConfig {

    @Bean
    @Scope("singleton")
    public Pet catBean() {
        return new Cat();
    }

    @Bean
    public Person personBean() {
        return new Person(catBean());
    }



}
