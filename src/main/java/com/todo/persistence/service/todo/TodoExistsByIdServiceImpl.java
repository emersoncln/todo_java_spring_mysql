package com.todo.persistence.service.todo;

import com.todo.persistence.repository.todo.TodoRepository;
import org.springframework.stereotype.Component;

@Component
public class TodoExistsByIdServiceImpl implements TodoExistsByIdService {
    private final TodoRepository todoRepository;

    public TodoExistsByIdServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public Boolean exists(Long id) {
        return todoRepository.existsById(id);
    }
}
