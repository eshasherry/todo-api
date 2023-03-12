package com.rest.webservice.todoapi.controller;

import com.rest.webservice.todoapi.entity.Todo;
import com.rest.webservice.todoapi.exception.TodoNotFoundException;
import com.rest.webservice.todoapi.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {
    @Autowired
    TodoRepository todoRepository;
    @GetMapping("users/{username}/todos")
    public ResponseEntity<List<Todo>> getTodos(@PathVariable String username){
        return new ResponseEntity<>(todoRepository.findTodosByUsername(username), HttpStatus.OK);
    }
    @DeleteMapping("todo/{id}")
    public void deleteTodos(@PathVariable int id){
        todoRepository.deleteById(id);
    }
    @GetMapping("users/{username}/todo/{id}")
    public ResponseEntity<Todo> getTodo(@PathVariable String username, @PathVariable int id){
        Todo todo = todoRepository.findTodosByUsernameAndId(username, id);
        if(todo == null )throw new TodoNotFoundException("Todo not found with id: "+id);
        return new ResponseEntity<>(todo, HttpStatus.OK);
    }
    @PutMapping("users/{username}/todo/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable int id, @RequestBody Todo todo){
           //there is no update method in jpa repository. the save method does the update and create
           Todo updatedTodo = todoRepository.save(todo);
           return new ResponseEntity<>(updatedTodo, HttpStatus.OK);
    }
    @PostMapping("users/{username}/todo")
    public ResponseEntity<Todo> addTodo(@PathVariable String username, @RequestBody Todo todo){
        //there is no update method in jpa repository. the save method does the update and create
        return new ResponseEntity<>(todoRepository.save(todo), HttpStatus.OK);
    }
}
