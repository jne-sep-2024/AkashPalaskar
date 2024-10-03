package com.think.restful_web_service.service;

import com.think.restful_web_service.dao.Post;
import com.think.restful_web_service.dao.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private static List<User> users = new ArrayList<>();
    private static List<Post> posts = new ArrayList<>();
    private static int userCount = 0;

    static {
        users.add(new User(++userCount, "Adam", LocalDate.now().minusYears(30),posts));
        users.add(new User(++userCount, "Eve", LocalDate.now().minusYears(25),posts));
        users.add(new User(++userCount, "Jim", LocalDate.now().minusYears(20),posts));
    }


    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        user.setId(++userCount);
        users.add(user);
        return user;
    }

    public User findById(int id) {
        User user = users.stream().filter(item -> item.getId() == id).findFirst().orElse(null);
        return user;
    }

    public User deleteById(int id) {
        User user = users.stream().filter(item -> item.getId() == id).findFirst().orElse(null);
        users.remove(user);
        return user;
    }
}
