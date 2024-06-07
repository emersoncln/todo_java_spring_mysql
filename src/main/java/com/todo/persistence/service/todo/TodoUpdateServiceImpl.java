package com.todo.persistence.service.todo;

import com.todo.persistence.repository.todo.TodoDataMapper;
import com.todo.persistence.repository.todo.TodoRepository;
import org.springframework.stereotype.Component;

@Component
public class TodoUpdateServiceImpl implements TodoUpdateService {
    private final TodoRepository todoRepository;
    private final TodoDsConverter todoConverter;

    public TodoUpdateServiceImpl(TodoRepository todoRepository, TodoDsConverter todoConverter) {
        this.todoRepository = todoRepository;
        this.todoConverter = todoConverter;
    }
    @Override
    public void update(Long id, TodoDsModel model) {
        TodoDataMapper mapper = todoConverter.convertFromDsModelToMapper(model);
        todoRepository.save(mapper);
    }
}
