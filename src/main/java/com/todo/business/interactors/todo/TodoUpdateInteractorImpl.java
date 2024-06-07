package com.todo.business.interactors.todo;

import com.todo.business.models.Todo;
import com.todo.business.models.TodoFactory;
import com.todo.persistence.service.todo.*;
import com.todo.presentation.todo.TodoPresenter;
import com.todo.presentation.todo.TodoRequestModel;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class TodoUpdateInteractorImpl implements TodoUpdateInteractor {

    private final TodoExistsByNameAndIdNotService todoExistsByNameAndIdNotService;
    private final TodoExistsByIdService todoExistsByIdService;
    private final TodoUpdateService todoUpdateService;
    private final TodoPresenter todoPresenter;
    private final TodoDsConverter todoDsConverter;
    private final TodoFactory todoFactory;

    public TodoUpdateInteractorImpl(TodoExistsByNameAndIdNotService todoExistsByNameAndIdNotService, TodoExistsByIdService todoExistsByIdService, TodoUpdateService todoUpdateService, TodoPresenter todoPresenter, TodoDsConverter todoDsConverter, TodoFactory todoFactory) {
        this.todoExistsByNameAndIdNotService = todoExistsByNameAndIdNotService;
        this.todoExistsByIdService = todoExistsByIdService;
        this.todoUpdateService = todoUpdateService;
        this.todoPresenter = todoPresenter;
        this.todoDsConverter = todoDsConverter;
        this.todoFactory = todoFactory;
    }

    @Override
    public void update(Long id, TodoRequestModel model) {
        if (todoExistsByIdService.exists(id)) {
            Todo todo = todoFactory.create(id, model.getName(), model.getChecked());

            if (!todo.isNameValid()) {
                todoPresenter.error(HttpStatus.CONFLICT, "Nome inválido.");
                return;
            }

            if (todoExistsByNameAndIdNotService.exists(id, model.getName())) {
                todoPresenter.error(HttpStatus.CONFLICT, "Já existe um To do com o mesmo nome cadastrado.");
                return;
            }

            TodoDsModel dsModel = todoDsConverter.convertFromTodoToDsModel(todo);
            todoUpdateService.update(id, dsModel);
        } else {
            todoPresenter.error(HttpStatus.NOT_FOUND, "To do não encontrado.");
        }
    }
}
