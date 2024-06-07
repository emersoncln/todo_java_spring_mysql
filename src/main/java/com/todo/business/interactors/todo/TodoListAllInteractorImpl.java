package com.todo.business.interactors.todo;
import com.todo.persistence.service.todo.TodoListAllService;
import com.todo.presentation.todo.TodoPresenter;
import com.todo.presentation.todo.TodoResponseModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TodoListAllInteractorImpl implements TodoListAllInteractor {
    private final TodoListAllService todolistAllService;
    private final TodoPresenter todoPresenter;
    public TodoListAllInteractorImpl(TodoListAllService todoListAllService, TodoPresenter todoPresenter) {
        this.todolistAllService = todoListAllService;
        this.todoPresenter = todoPresenter;
    }

    @Override
    public List<TodoResponseModel> listAll() {
         return todolistAllService.listAll()
                .stream()
                .map(todoPresenter::success)
                .collect(Collectors.toList());
    }
}
