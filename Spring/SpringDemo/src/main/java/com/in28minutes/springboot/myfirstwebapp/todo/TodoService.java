package com.in28minutes.springboot.myfirstwebapp.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();

    private static int todosCount =0;
    static {
      todos.add(new Todo(++todosCount,"raj","Learn AWS 1", LocalDate.now().plusYears(1), false));

      todos.add(new Todo(++todosCount,"raj","Learn AZURE 1",LocalDate.now().plusYears(1),false));

      todos.add(new Todo(++todosCount,"raj","Learn GCP 1", LocalDate.now().plusYears(2),true) );
    }

    public List<Todo> findByUsername(String username) {
        return todos.stream().filter(todo->todo.getUsername().equalsIgnoreCase(username)).toList();
    }

    public void addTodo(String username, String description, LocalDate targetDate,boolean done){

        Todo todo = new Todo(++todosCount,username,description,targetDate,done);

        todos.add(todo);

    }

    public void deleteById(int id){

        todos.removeIf(todo -> todo.getId() == id);
    }

    public Todo findById(int id) {

       return todos.stream().filter(todo->todo.getId() == id).findFirst().get();
    }

    public void updateTodo(@Valid Todo todo){
        deleteById(todo.getId());

        todos.add(todo);
    }
}
