package com.todo.business.interactors.todo;

import com.todo.business.models.Todo;
import com.todo.business.models.TodoFactory;
import com.todo.persistence.service.todo.TodoDsConverter;
import com.todo.persistence.service.todo.TodoDsModel;
import com.todo.persistence.service.todo.TodoInsertService;
import com.todo.presentation.todo.TodoPresenter;
import com.todo.presentation.todo.TodoRequestModel;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class TodoInsertInteractorImpl implements TodoInsertInteractor {
    private final TodoFactory todoFactory;
    private final TodoPresenter todoPresenter;
    private final TodoInsertService todoInsertService;
    private final TodoDsConverter todoDsConverter;

    public TodoInsertInteractorImpl(TodoFactory todoFactory,TodoPresenter todoPresenter, TodoInsertService todoInsertService, TodoDsConverter todoDsConverter) {
        this.todoFactory = todoFactory;
        this.todoPresenter = todoPresenter;
        this.todoInsertService = todoInsertService;
        this.todoDsConverter = todoDsConverter;
    }

    @Override
    public void insert(TodoRequestModel model) {
        Todo todo = todoFactory.create(-1L, model.getName(), model.getChecked());

        if (!todo.isNameValid()) {
            todoPresenter.error(HttpStatus.CONFLICT, "Nome inválido.");
            return;
        }

        TodoDsModel dsModel = todoDsConverter.convertFromTodoToDsModel(todo);
        todoInsertService.insert(dsModel);
    }
}
