//package com.think.restful_web_service.service;
//
//import com.think.restful_web_service.dao.Role;
//import com.think.restful_web_service.dao.User;
//import com.think.restful_web_service.repository.RolesRepository;
//import com.think.restful_web_service.repository.UserRepository;
//import jakarta.annotation.PostConstruct;
//import jakarta.transaction.Transactional;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//
//
//@Component
//public class DatabaseInitializer {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private RolesRepository roleRepository;
//
//    @PostConstruct
//    @Transactional
//    public void initialize() {
//        Role roleUser = new Role(1, "ROLE_USER");
//        Role roleAdmin = new Role(2, "ROLE_ADMIN");
//        roleRepository.save(roleUser);
//        roleRepository.save(roleAdmin);
//
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String encodedPassword = passwordEncoder.encode("dummy2");
//
//        User user1 = new User(1, "think", LocalDate.now().minusYears(10),encodedPassword, roleUser,new ArrayList<>());
//        User user2 = new User(2, "think2", LocalDate.now().minusYears(20),encodedPassword, roleAdmin,new ArrayList<>());
//
//        userRepository.save(user1);
//        userRepository.save(user2);
//    }
//}
//
