package com.think.my_first_webapp.todo;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoController {


    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping("/list-todos")
    public String listAllTodos(ModelMap modelMap) {
        String username = getLoggedinUsername();

        List<Todo> todos = todoService.findByUsername(username);
        modelMap.addAttribute("todos", todos);
        return "listTodos";
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.GET)
    public String showNewtodopage(ModelMap model) {
        String username = getLoggedinUsername();

//        Todo todo = new Todo(0, username, "", LocalDate.now().plusYears(1), false);

        Todo todo = new Todo();
        model.put("todo", todo);
        return "todo";
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.POST)
    public String addNewtodo(ModelMap model, @Valid Todo todo, BindingResult result) {

        if (result.hasErrors()) {

            return "todo";
        }
        System.out.println(todo);
        String username = getLoggedinUsername();
        todoService.addTodo(username, todo.getDescription(), todo.getTargetDate(), false);

        return "redirect:list-todos";
    }

    @RequestMapping("delete-todo")
    public String deletetodo(@RequestParam int id) {

        todoService.deldetebyId(id);
        return "redirect:list-todos";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.GET)
    public String updatetodo(@RequestParam int id, ModelMap model) {
        String username = getLoggedinUsername();
        Todo todo = todoService.findById(id);
        model.addAttribute("todo", todo);
        return "updateTodo";
    }


    @RequestMapping(value = "/update-todo", method = RequestMethod.POST)
    public String showUpdatestodo(ModelMap model, @Valid Todo todo, BindingResult result) {

        if (result.hasErrors()) {

            return "todo";
        }
        String username = getLoggedinUsername();
        todoService.updateById(todo);
        return "redirect:list-todos";
    }


    private String getLoggedinUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        return name;
    }

}
