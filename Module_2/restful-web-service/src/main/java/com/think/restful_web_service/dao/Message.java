package com.think.restful_web_service.dao;

import jakarta.persistence.*;

import java.time.LocalTime;

@Entity

public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String description;
    private LocalTime sendedtime;
    @OneToOne
    private  User user;

}
