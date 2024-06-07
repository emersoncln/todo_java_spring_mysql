package com.todo.persistence.service.todo;

import com.todo.persistence.repository.todo.TodoRepository;
import org.springframework.stereotype.Component;

@Component
public class TodoDeleteByIdServiceImpl implements TodoDeleteByIdService {
    private final TodoRepository todoRepository;

    public TodoDeleteByIdServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public void deleteById(Long id) {
        todoRepository.deleteById(id);
    }
}
