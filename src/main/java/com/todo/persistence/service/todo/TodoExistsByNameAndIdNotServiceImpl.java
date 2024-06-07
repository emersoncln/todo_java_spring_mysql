package com.todo.persistence.service.todo;

import com.todo.persistence.repository.todo.TodoRepository;
import org.springframework.stereotype.Component;

@Component
public class TodoExistsByNameAndIdNotServiceImpl  implements  TodoExistsByNameAndIdNotService {
    private final TodoRepository todoRepository;

    public TodoExistsByNameAndIdNotServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }
    @Override
    public Boolean exists(Long id, String name) {
        return todoRepository.existsByNameAndIdNot(name,id);
    }
}
