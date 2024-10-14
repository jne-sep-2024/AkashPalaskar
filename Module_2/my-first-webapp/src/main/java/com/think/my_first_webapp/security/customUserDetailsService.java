package com.think.my_first_webapp.security;

import com.think.my_first_webapp.dao.UserRepository;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class customUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username);
        com.think.my_first_webapp.dao.User user = repository.findByUsername(username);
        System.out.println(user);
        String loginUsername = user.getUsername();
        String password = user.getPassword();
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = Collections.singletonList(new SimpleGrantedAuthority(user.getRoles().getRole()));

        return new User(loginUsername,password,simpleGrantedAuthorities);
    }
}
