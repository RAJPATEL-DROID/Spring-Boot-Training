package com.in28minutes.springboot.myfirstwebapp.todo;

import jakarta.validation.Valid;
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
public class TodoControllerjpa {

    public TodoControllerjpa(TodoRepository todoRepository) {

        this.todoRepository  = todoRepository;
    }

    private TodoRepository todoRepository;

    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap model)
    {
        List<Todo> todos = todoRepository.findByUsername(getLoggedInUserName(model));

        model.addAttribute("todos", todos);

        return "list-todos";
    }


    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String ShowNewTodo(ModelMap model)
    {
        Todo todo = new Todo(0,getLoggedInUserName(model),"",LocalDate.now().plusYears(1),false);
        model.put("todo",  todo);
        return "todo";
    }

    @RequestMapping(value = "add-todo",method = RequestMethod.POST)
    public String addNewTodo(ModelMap model,@Valid Todo todo, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "todo";
        }
        todo.setUsername(getLoggedInUserName(model));

        todoRepository.save(todo);

        return "redirect:list-todos";
    }

    @RequestMapping(value = "delete-todo")
    public String deleteTodo(@RequestParam int id){

        todoRepository.deleteById(id);

        return "redirect:list-todos";
    }

    @RequestMapping(value="update-todo", method = RequestMethod.GET)
    public String showUpdateTodoPage(@RequestParam int id,ModelMap model){

        Todo todo = todoRepository.findById(id).get();

        model.addAttribute("todo", todo);

        return "todo";
    }

    @RequestMapping(value="update-todo",method = RequestMethod.POST)
    public String updateTodo(ModelMap model, Todo todo,BindingResult result) {

        if (result.hasErrors()) {
            return "todo";
        }

        todo.setUsername(getLoggedInUserName(model));

        todoRepository.save(todo);

        return "redirect:list-todos";
    }

    private String getLoggedInUserName(ModelMap model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return authentication.getName();
    }
}
