package com.todo.persistence.service.todo;

import com.todo.business.models.Todo;
import com.todo.persistence.repository.todo.TodoDataMapper;

public interface TodoDsConverter  {
    TodoDsModel convertFromMapperToDsModel(TodoDataMapper todoDataMapper);
    TodoDataMapper convertFromDsModelToMapper(TodoDsModel todoDsModel);
    TodoDsModel convertFromTodoToDsModel(Todo todo);
}
