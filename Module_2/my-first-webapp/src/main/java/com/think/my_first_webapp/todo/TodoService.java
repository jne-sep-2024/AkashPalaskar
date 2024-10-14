package com.think.my_first_webapp.todo;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class TodoService {

@Autowired
private  TodoRepository repository;



//    private static List<Todo> todos = new ArrayList<>();

    private static int todosCount = 0;

//    static {
//        repository.save(new Todo(++todosCount, "think", "learn AWS Certified",
//                LocalDate.now().plusYears(1), false));
//        repository.save(new Todo(++todosCount, "think", "learn DevOps",
//                LocalDate.now().plusYears(2), false));
//        repository.save(new Todo(++todosCount, "think", "learn Kafka",
//                LocalDate.now().plusYears(3), false));
//        repository.save(new Todo(++todosCount, "think2", "learn React",
//                LocalDate.now().plusYears(3), false));
//        repository.save(new Todo(++todosCount, "think2", "learn Redux",
//                LocalDate.now().plusYears(3), false));
//        repository.save(new Todo(++todosCount, "think2", "learn R lang",
//                LocalDate.now().plusYears(3), false));
//        repository.save(new Todo(++todosCount, "think2", "learn Redis",
//                LocalDate.now().plusYears(3), false));
//
//    }

    public List<Todo> findByUsername(String username) {

//        return todos.stream().filter(todo -> Objects.equals(todo.getUsername(), username)).collect(Collectors.toList());
    return repository.findByUsername(username);
    }
    public List<Todo> addTodo(String username,String description,LocalDate targetdate,boolean done) {
        Todo todo=new Todo(++todosCount,username,description,targetdate,done);
//        todos.add(todo);
//        System.out.println(todos);
//        return todos;
        repository.save(todo);
        return repository.findAll();
    }

    public void deldetebyId(int id){

//        Predicate<? super Todo> predecate=todo -> todo.getId() == id    ;
//        todos.removeIf(predecate);
        repository.deleteById(id);

//        todos.get(id);
//        todos.remove(todos.get(id));
    }

    public Todo findById(int id) {
//        Predicate<? super Todo> predecate=todo -> todo.getId() == id    ;
//        Todo todo = todos.stream().filter(predecate).findFirst().get();
//        return todo;
        return   repository.findById(id).get();

    }

    public void updateById(@Valid Todo todo ) {
//        deldetebyId(todo.getId());
//        todos.add(todo);

        repository.deleteById(todo.getId());
        repository.save(todo);

    }
}



