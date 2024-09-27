package com.think.my_first_webapp.security;

import com.think.my_first_webapp.dao.Role;
import com.think.my_first_webapp.dao.RoleRepository;
import com.think.my_first_webapp.dao.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.function.Function;


@Configuration
public class SpringSecurityConfigurstion {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository repository;

    @Bean
    public String Saveuser() {

        Role role = new Role(1, "ROLE_USER");
        Role role2 = new Role(2, "ROLE_ADMIN");
        repository.save(role);
        repository.save(role2);

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode("dummy2");

        com.think.my_first_webapp.dao.User user = new com.think.my_first_webapp.dao.User(1, "think", encodedPassword, role);
        com.think.my_first_webapp.dao.User user2 = new com.think.my_first_webapp.dao.User(2, "think2", encodedPassword, role2);

        userRepository.save(user);
        userRepository.save(user2);

        return "saved";

    }

//    @Bean
//    public InMemoryUserDetailsManager createUserDetailsManager() {
//
//
//        UserDetails user = createuser("think", "dummy");
//        UserDetails user2 = createuser("think2", "dummy");
//
//
//
//        return new InMemoryUserDetailsManager(user,user2);
//    }
//
//    private UserDetails createuser(String username, String password) {
//        Function<String, String> passwordEncoder
//                = input -> passwordEncoder().encode(input);
//
//        UserDetails user = User.builder()
//                .passwordEncoder(passwordEncoder)
//                .username(username)
//                .password(password)
//                .roles("ADMIN", "USER")
//                .build();
//        return user;
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf(csrf -> csrf.disable())
                .headers(head -> head.frameOptions(frame -> frame.disable()))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/h2-console/*").hasRole("ADMIN")
                        .anyRequest().authenticated())
                .formLogin(Customizer.withDefaults());

        return httpSecurity.build();
    }

}

