package com.todo.presentation.todo;

import com.todo.persistence.service.todo.TodoDsModel;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class TodoPresenterImpl implements TodoPresenter {
    ModelMapper mapper;
    public TodoPresenterImpl(ModelMapper mapper) {
        this.mapper = mapper;
    }
    @Override
    public TodoResponseModel success(TodoDsModel todoDsModel) {
        return mapper.map(todoDsModel, TodoResponseModel.class);
    }
    @Override
    public TodoResponseModel error(HttpStatus status, String error) {
        throw new ResponseStatusException(status, error);
    }
}
