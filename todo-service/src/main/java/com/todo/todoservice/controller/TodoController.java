package com.todo.todoservice.controller;

import com.todo.todoservice.molel.Todo;
import com.todo.todoservice.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    TodoService service;

    @PostMapping
    public ResponseEntity<Todo> add(@RequestBody Todo t){
        Todo todo = new Todo(t.getName(),t.getType(),t.getDisription());
        return  new ResponseEntity<>(service.addTodo(t),HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Todo>> getAll(){
       return new ResponseEntity<>(service.getAll(),HttpStatus.ACCEPTED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Todo> getById(@PathVariable("id") Long id){
        if(!service.getAllById(id).isPresent()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(service.getAllById(id).get(),HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        if(!service.getAllById(id).isPresent()){
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(service.deleteById(id),HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Todo> update(@RequestBody Todo t, @PathVariable("id") Long id){

        return new ResponseEntity<>(service.update(t, id),HttpStatus.OK);
    }
}
