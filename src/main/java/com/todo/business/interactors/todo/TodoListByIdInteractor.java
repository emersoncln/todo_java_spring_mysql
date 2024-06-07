package com.todo.business.interactors.todo;

import com.todo.presentation.todo.TodoResponseModel;

public interface TodoListByIdInteractor {
    TodoResponseModel findById(Long id);
}
