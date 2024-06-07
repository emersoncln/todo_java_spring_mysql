package com.todo.persistence.repository.todo;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface TodoRepository extends CrudRepository<TodoDataMapper, Long> {
    List<TodoDataMapper> findAllByCheckedFalse();
    Boolean existsByNameAndIdNot(String name, Long id);
}
