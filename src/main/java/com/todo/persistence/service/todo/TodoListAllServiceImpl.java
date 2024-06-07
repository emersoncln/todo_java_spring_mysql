package com.todo.persistence.service.todo;

import com.todo.persistence.repository.todo.TodoRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TodoListAllServiceImpl implements TodoListAllService {
    private final TodoRepository todoRepository;
    private final TodoDsConverter todoConverter;

    public TodoListAllServiceImpl(TodoRepository todoRepository, TodoDsConverter todoConverter) {
        this.todoRepository = todoRepository;
        this.todoConverter = todoConverter;
    }

    @Override
    public List<TodoDsModel> listAll() {

        // List<TodoDsModel> result = new ArrayList<>();
        //
        //        List<TodoDataMapper> list = TodoRepositoy.findAllByCheckedFalse();
        //        list.forEach(it -> result.add(todoConverter.convert(it)));
        //
        //        return result;

        return todoRepository.findAllByCheckedFalse()
                .stream()
                .map(todoConverter::convertFromMapperToDsModel)
                .toList();
    }
}
