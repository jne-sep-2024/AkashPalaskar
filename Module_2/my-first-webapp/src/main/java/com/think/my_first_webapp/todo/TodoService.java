package com.think.my_first_webapp.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {


    private static List<Todo> todos = new ArrayList<>();

    private static int todosCount = 0;

    static {
        todos.add(new Todo(++todosCount, "think", "learn AWS Certified",
                LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++todosCount, "think", "learn DevOps",
                LocalDate.now().plusYears(2), false));
        todos.add(new Todo(++todosCount, "think", "learn Kafka",
                LocalDate.now().plusYears(3), false));

    }

    public List<Todo> findByUsername(String username) {

        return todos;
    }
    public List<Todo> addTodo(String username,String description,LocalDate targetdate,boolean done) {
        Todo todo=new Todo(++todosCount,username,description,targetdate,done);
        todos.add(todo);
        System.out.println(todos);
        return todos;
    }

    public void deldetebyId(int id){
        System.out.println(id);
        Predicate<? super Todo> predecate=todo -> todo.getId() == id    ;
        todos.removeIf(predecate);
//        todos.get(id);
//        todos.remove(todos.get(id));
    }

    public Todo findById(int id) {
        Predicate<? super Todo> predecate=todo -> todo.getId() == id    ;
        Todo todo = todos.stream().filter(predecate).findFirst().get();
        return todo;
    }

    public void updateById(@Valid Todo todo ) {

        deldetebyId(todo.getId());
        todos.add(todo);

    }
}



