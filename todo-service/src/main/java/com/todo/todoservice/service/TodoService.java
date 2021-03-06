package com.todo.todoservice.service;

import com.todo.todoservice.molel.Todo;
import com.todo.todoservice.repository.TodaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    TodaoRepository repo;

    public List<Todo> getAll() {
        return repo.findAll();
    }

    public Todo addTodo(Todo t) {
        return  repo.save(t);
    }

    public Optional<Todo> getAllById(Long id) {
        return repo.findById(id);
    }

    public String deleteById(Long id) {

         repo.deleteById(id);
         return "Deleted!";
    }
    public Todo update(Todo t, Long id){
        t.setId(id);
        return repo.save(t);
    }
}
