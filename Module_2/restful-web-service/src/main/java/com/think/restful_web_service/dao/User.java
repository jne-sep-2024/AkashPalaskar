package com.think.restful_web_service.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
//import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "user_details")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    @Size(min = 2,message = "Name Sholud Have At Least 2 Characters")
    @JsonProperty("user_name")
    private  String name;

    @Past(message = "Birth Date Should Be In Past")
    @JsonProperty("brith_date")
    private LocalDate birthDate;



    private String password;

    @ManyToOne()
    @JoinColumn(name = "role_id")
    private Role roles;



    @OneToMany(mappedBy = "user")
    @JsonManagedReference
//    @JsonIgnore
//    @JoinColumn (name = "post_id")
    private List<Post> posts;

    public User(Integer id, String name, LocalDate birthDate, String password, Role roles, List<Post> posts) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.password = password;
        this.roles = roles;
        this.posts = posts;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRoles() {
        return roles;
    }

    public void setRoles(Role roles) {
        this.roles = roles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }


    public User() {

    }
}
