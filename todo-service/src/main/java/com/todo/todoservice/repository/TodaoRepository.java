package com.todo.todoservice.repository;

import com.todo.todoservice.molel.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TodaoRepository extends JpaRepository<Todo, Long>{
}
