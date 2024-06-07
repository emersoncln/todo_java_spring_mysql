package com.todo.business.interactors.todo;

import com.todo.persistence.service.todo.TodoDeleteByIdService;
import com.todo.persistence.service.todo.TodoExistsByIdService;
import com.todo.presentation.todo.TodoPresenter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class TodoDeleteByIdInteractorImpl implements TodoDeleteByIdInteractor {
    private final TodoDeleteByIdService todoDeleteByIdService;
    private final TodoExistsByIdService todoExistsByIdService;
    private final TodoPresenter todoPresenter;

    public TodoDeleteByIdInteractorImpl(TodoDeleteByIdService todoDeleteByIdService, TodoExistsByIdService todoExistsByIdService, TodoPresenter todoPresenter) {
        this.todoDeleteByIdService = todoDeleteByIdService;
        this.todoExistsByIdService = todoExistsByIdService;
        this.todoPresenter = todoPresenter;
    }

    @Override
    public void delete(Long id) {
        if (todoExistsByIdService.exists(id)) {
            todoDeleteByIdService.deleteById(id);
        } else {
            todoPresenter.error(HttpStatus.NOT_FOUND, "To do não encontrado.");
        }
    }
}