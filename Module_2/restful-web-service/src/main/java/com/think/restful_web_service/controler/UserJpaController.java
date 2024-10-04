package com.think.restful_web_service.controler;

import com.think.restful_web_service.ExceptionHandling.UserNotFoundException;
import com.think.restful_web_service.dao.Post;
import com.think.restful_web_service.dao.Role;
import com.think.restful_web_service.dao.User;
import com.think.restful_web_service.repository.PostRepository;
import com.think.restful_web_service.repository.RolesRepository;
import com.think.restful_web_service.repository.UserRepository;
import com.think.restful_web_service.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
//@RequestMapping("/users")
public class UserJpaController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository repository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private RolesRepository rolesRepository;

    @GetMapping("/jpa-users")
    public List<User> retriveAllUser() {
        System.out.println(repository.findAll());
        return repository.findAll();
    }

    @GetMapping("/jpa-users/{id}")
    public EntityModel retriveAfindbyUserIdUser(@PathVariable int id) throws UserNotFoundException {
        User user = repository.findById(id).get();
        if (user == null) {
            throw new UserNotFoundException("Id :" + id + " Not Found");
        }
        System.out.println(user.getPosts());
        EntityModel entityModel = EntityModel.of(user);
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retriveAllUser());
//        WebMvcLinkBuilder deletelink = linkTo(methodOn(this.getClass()).deleteByid(1));


        entityModel.add(link.withRel("all-users"));
//        entityModel.add(deletelink.withRel("delete-user"));
        System.out.println("------------------");
        System.out.println(entityModel);

        return entityModel;
    }


    @GetMapping("/jpa-users/{id}/post")
    public List<Post> retrivePostForUserId(@PathVariable int id) throws UserNotFoundException {
        User user = repository.findById(id).get();
        if (user == null) {
            throw new UserNotFoundException("Id :" + id + " Not Found");
        }
        System.out.println(user);
        System.out.println(user.getPosts());

        System.out.println(user.getPosts().get(0).getComments());
        return user.getPosts();
    }

    @DeleteMapping("/jpa-users/{id}")
    public User deleteByid(@PathVariable int id) throws UserNotFoundException {

        User user = repository.findById(id).get();
        System.out.println(user);
        repository.deleteById(id);

        if (user == null) {
            throw new UserNotFoundException("Id :" + id + " Not Found");
        }
        return user;
    }

    @PostMapping("/jpa-users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) throws URISyntaxException {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());

        user.setPassword(encodedPassword);

        Role role = rolesRepository.findById(1).get();

        user.setRoles(role);


        User userAdded = repository.save(user);


        System.out.println(userAdded);
//        URI location = ServletUriComponentsBuilder
//                .fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(userAdded.getId())
//                .toUri();
//        return ResponseEntity.created(location).build(); // to get location in header

        return new ResponseEntity<>(userAdded, HttpStatus.CREATED);

    }


    @PostMapping("/jpa-users/{id}/posts")
    public ResponseEntity<Post> SavePost(@PathVariable int id, @Valid @RequestBody Post post) throws UserNotFoundException {
        User user = repository.findById(id).get();

        if (user == null) {
            throw new UserNotFoundException("Id :" + id + " Not Found");
        }
        post.setUser(user);
        Post savePost = postRepository.save(post);
//        return user.getPosts();

        return new ResponseEntity<>(savePost, HttpStatus.CREATED);

    }


}
