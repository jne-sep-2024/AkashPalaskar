package com.think.restful_web_service.security;

import com.think.restful_web_service.dao.User;
import com.think.restful_web_service.repository.RolesRepository;
import com.think.restful_web_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;


@Service
public class CustomUserDetailsServices implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RolesRepository rolesRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByName(username);
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = Collections.singletonList(new SimpleGrantedAuthority(user.getRoles().getRole()));

        System.out.println(username);
        System.out.println(user);

        return new org.springframework.security.core.userdetails.User(
                user.getName(),
                user.getPassword(),
                simpleGrantedAuthorities);


    }

    ;
}
