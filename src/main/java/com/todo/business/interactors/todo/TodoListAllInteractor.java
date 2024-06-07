package com.todo.business.interactors.todo;
import com.todo.presentation.todo.TodoResponseModel;
import java.util.List;

public interface TodoListAllInteractor {
    List<TodoResponseModel> listAll();
}
