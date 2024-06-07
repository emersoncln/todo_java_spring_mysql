package com.todo.business.interactors.todo;

import com.todo.presentation.todo.TodoRequestModel;

public interface TodoUpdateInteractor {
    void update(Long id, TodoRequestModel model);
}
