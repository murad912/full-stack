package com.todo.todoservice.service;

import com.todo.todoservice.molel.Todo;
import com.todo.todoservice.repository.TodaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Todo getAllById(Long id) {
        return repo.findById(id).get();
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
