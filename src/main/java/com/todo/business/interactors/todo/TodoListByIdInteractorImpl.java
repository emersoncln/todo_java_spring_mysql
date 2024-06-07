package com.todo.business.interactors.todo;

import com.todo.persistence.service.todo.TodoDsModel;
import com.todo.persistence.service.todo.TodoFindByIdService;
import com.todo.presentation.todo.TodoPresenter;
import com.todo.presentation.todo.TodoResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class TodoListByIdInteractorImpl implements TodoListByIdInteractor {
    private final TodoFindByIdService todoFindByIdService;
    private final TodoPresenter todoPresenter;
    public TodoListByIdInteractorImpl(TodoFindByIdService todoFindByIdService, TodoPresenter todoPresenter) {
        this.todoFindByIdService = todoFindByIdService;
        this.todoPresenter = todoPresenter;
    }
    @Override
    public TodoResponseModel findById(Long id) {
         TodoDsModel result = todoFindByIdService.findById(id);

         if (result != null) {
            return todoPresenter.success(result);
         }
         return todoPresenter.error(HttpStatus.NOT_FOUND, "To do não encontrado.");
    }
}