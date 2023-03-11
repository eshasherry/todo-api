package com.rest.webservice.todoapi.controller;

import com.rest.webservice.todoapi.entity.Todo;
import com.rest.webservice.todoapi.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {
    @Autowired
    TodoRepository todoRepository;
    @GetMapping("users/{username}/todos")
    public List<Todo> getTodos(@PathVariable String username){
        return todoRepository.findTodosByUsername(username);
    }
    @DeleteMapping("todo/{id}")
    public void deleteTodos(@PathVariable int id){
        todoRepository.deleteById(id);
    }
    @GetMapping("users/{username}/todo/{id}")
    public Todo getTodo(@PathVariable String username, @PathVariable int id){
        return todoRepository.findTodosByUsernameAndId(username, id);
    }
    @PutMapping("users/{username}/todo/{id}")
    public Todo updateTodo(@PathVariable String username, @PathVariable int id, @RequestBody Todo todo){
           //there is no update method in jpa repository. the save method does the update and create
           todoRepository.save(todo);
           return todo;
    }
    @PostMapping("users/{username}/todo")
    public Todo addTodo(@PathVariable String username, @RequestBody Todo todo){
        //there is no update method in jpa repository. the save method does the update and create
        return todoRepository.save(todo);
    }
}
