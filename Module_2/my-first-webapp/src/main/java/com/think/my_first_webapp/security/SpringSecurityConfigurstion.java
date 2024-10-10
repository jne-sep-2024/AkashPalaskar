package com.think.my_first_webapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SpringSecurityConfigurstion {


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
//                        .requestMatchers("/").permitAll()
                        .requestMatchers("/h2-console/*").hasRole("ADMIN")
                        .anyRequest().authenticated())
                .formLogin(Customizer.withDefaults());

        return httpSecurity.build();
    }

}

