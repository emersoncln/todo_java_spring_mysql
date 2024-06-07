package com.todo.persistence.service.todo;

public interface TodoExistsByNameAndIdNotService {
    Boolean exists(Long id, String name);
}
