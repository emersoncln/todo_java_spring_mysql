package com.todo.presentation.todo;

import com.todo.persistence.service.todo.TodoDsModel;
import org.springframework.http.HttpStatus;

public interface TodoPresenter {
    TodoResponseModel success(TodoDsModel todoDsModel);

    TodoResponseModel error(HttpStatus status, String error);
}
