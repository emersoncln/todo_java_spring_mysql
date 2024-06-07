package com.todo.persistence.service.todo;

import com.todo.persistence.repository.todo.TodoDataMapper;
import com.todo.persistence.repository.todo.TodoRepository;
import org.springframework.stereotype.Component;

@Component
public class TodoInsertServiceImpl implements TodoInsertService {
    private final TodoRepository todoRepository;
    private final TodoDsConverter todoConverter;

    public TodoInsertServiceImpl(TodoRepository todoRepository, TodoDsConverter todoConverter) {
        this.todoRepository = todoRepository;
        this.todoConverter = todoConverter;
    }
    @Override
    public void insert(TodoDsModel todo) {
        TodoDataMapper mapper = todoConverter.convertFromDsModelToMapper(todo);
        todoRepository.save(mapper);
    }
}
