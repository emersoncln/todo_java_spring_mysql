package com.todo.persistence.service.todo;

import com.todo.business.models.Todo;
import com.todo.persistence.repository.todo.TodoDataMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class TodoDsConverterImpl implements TodoDsConverter {
    private final ModelMapper mapper;
    public TodoDsConverterImpl(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public TodoDsModel convertFromMapperToDsModel(TodoDataMapper todoDataMapper) {
        return mapper.map(todoDataMapper, TodoDsModel.class);
    }

    @Override
    public TodoDataMapper convertFromDsModelToMapper(TodoDsModel todoDsModel) {
        return mapper.map(todoDsModel, TodoDataMapper.class);
    }

    @Override
    public TodoDsModel convertFromTodoToDsModel(Todo todo) {
        return mapper.map(todo, TodoDsModel.class);
    }
}
