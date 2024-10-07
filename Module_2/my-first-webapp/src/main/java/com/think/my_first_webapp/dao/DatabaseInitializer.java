package com.think.my_first_webapp.dao;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class DatabaseInitializer {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @PostConstruct
    @Transactional
    public void initialize() {
        Role roleUser = new Role(1, "ROLE_USER");
        Role roleAdmin = new Role(2, "ROLE_ADMIN");
        roleRepository.save(roleUser);
        roleRepository.save(roleAdmin);

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode("dummy2");

        User user1 = new User(1, "think", encodedPassword, roleUser);
        User user2 = new User(2, "think2", encodedPassword, roleAdmin);

        userRepository.save(user1);
        userRepository.save(user2);
    }
}
