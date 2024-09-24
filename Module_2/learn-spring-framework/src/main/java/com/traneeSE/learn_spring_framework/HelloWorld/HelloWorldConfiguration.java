package com.traneeSE.learn_spring_framework.HelloWorld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


record Person(String name, int age, Address address) {
};

record Address(String firstLine, String city) {
};

@Configuration
public class HelloWorldConfiguration {

    @Bean
    public String name() {
        return "Ranga";
    }

    @Bean
    public int age() {
        return 18;
    }

    @Bean
    public Person person() {
        return new Person("Ravi", 22, new Address("main street", "pune"));
    }

    @Bean
    public Person person2MehodCall() {
        return new Person(name(), age(), address());
    }

    @Bean
    public Person person3Parameters(String name, int age, Address address3) {
        return new Person(name, age, address3);
    }

    @Bean
    @Primary
    //no qualifying bean of type "com.traneeSE.learn_spring_framework.Address"
    //available: expected single matching bean but found 2 : address2, address3
    public Person person4Parameters(String name, int age, Address address) {
        return new Person(name, age, address);
    }

    @Bean
    public Person person5Parameters(String name, int age, @Qualifier("address3Qualifier")
    Address address) {
        return new Person(name, age, address);
    }


    @Bean(name = "address2")
    @Primary
    public Address address() {
        return new Address("Walker Street", "Nagpur");
    }

    @Bean(name = "address3")
    @Qualifier("address3Qualifier")
    public Address address3() {
        return new Address("Motinagar", "Hyderabad");
    }
}
