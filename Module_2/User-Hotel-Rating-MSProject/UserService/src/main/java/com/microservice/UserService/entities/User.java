package com.microservice.UserService.entities;

import com.microservice.UserService.dto.Rating;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String name;
    private String email;
    private String about;
    private String password;


    @ManyToOne()
    @JoinColumn(name = "role_id")
    private Role roles;
    @Transient
    private List<Rating> ratings = new ArrayList<>();
}
