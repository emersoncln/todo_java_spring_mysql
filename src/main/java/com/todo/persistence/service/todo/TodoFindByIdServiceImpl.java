package com.todo.persistence.service.todo;

import com.todo.persistence.repository.todo.TodoDataMapper;
import com.todo.persistence.repository.todo.TodoRepository;
import org.springframework.stereotype.Component;

@Component
public class TodoFindByIdServiceImpl implements TodoFindByIdService {
    private final TodoRepository todoRepository;
    private final TodoDsConverter todoConverter;

    public TodoFindByIdServiceImpl(TodoRepository todoRepository, TodoDsConverter todoConverter) {
        this.todoRepository = todoRepository;
        this.todoConverter = todoConverter;
    }

    @Override
    public TodoDsModel findById(Long id) {
        TodoDataMapper mapper = todoRepository.findById(id).orElse(null);

        if (mapper != null) {
            return todoConverter.convertFromMapperToDsModel(mapper);
        }
        return null;
    }
}
