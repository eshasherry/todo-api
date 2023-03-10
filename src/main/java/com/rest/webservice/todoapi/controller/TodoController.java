package com.rest.webservice.todoapi.controller;

import com.rest.webservice.todoapi.entity.Todo;
import com.rest.webservice.todoapi.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodoController {
    @Autowired
    TodoRepository todoRepository;
    @GetMapping("/{username}/todos")
    public List<Todo> getTodos(@PathVariable String username){
        return todoRepository.findTodosByUsername(username);
    }
    @DeleteMapping("/{id}/todo")
    public void deleteTodos(@PathVariable int id){
        todoRepository.deleteById(id);
    }
}
