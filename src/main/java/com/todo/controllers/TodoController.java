package com.todo.controllers;

import com.todo.business.interactors.todo.*;
import com.todo.presentation.todo.TodoRequestModel;
import com.todo.presentation.todo.TodoResponseModel;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {
    private final TodoListAllInteractor todoListAllInteractor;
    private final TodoListByIdInteractor todoListByIdInteractor;
    private final TodoDeleteByIdInteractor todoDeleteByIdInteractor;
    private final TodoInsertInteractor todoInsertInteractor;

    private final TodoUpdateInteractor todoUpdateInteractor;

    public TodoController(TodoListAllInteractor todoListAllInteractor, TodoListByIdInteractor todoListByIdInteractor, TodoDeleteByIdInteractor todoDeleteByIdInteractor, TodoInsertInteractor todoInsertInteractor, TodoUpdateInteractor todoUpdateInteractor) {
        this.todoListAllInteractor = todoListAllInteractor;
        this.todoListByIdInteractor = todoListByIdInteractor;
        this.todoDeleteByIdInteractor = todoDeleteByIdInteractor;
        this.todoInsertInteractor = todoInsertInteractor;
        this.todoUpdateInteractor = todoUpdateInteractor;
    }

    @GetMapping
    public List<TodoResponseModel> listAll() {
        return todoListAllInteractor.listAll();
    }

    @GetMapping("/{id}")
    public TodoResponseModel listById(@PathVariable Long id) {
        return todoListByIdInteractor.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        todoDeleteByIdInteractor.delete(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void insert(@RequestBody TodoRequestModel model) {
        todoInsertInteractor.insert(model);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable Long id, @RequestBody TodoRequestModel model) {
        todoUpdateInteractor.update(id, model);
    }
}
