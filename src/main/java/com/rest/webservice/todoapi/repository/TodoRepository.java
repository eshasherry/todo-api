package com.rest.webservice.todoapi.repository;

import com.rest.webservice.todoapi.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo,Integer> {
    List<Todo> findTodosByUsername(String username);
    Todo findTodosByUsernameAndId(String username, int id);
}
