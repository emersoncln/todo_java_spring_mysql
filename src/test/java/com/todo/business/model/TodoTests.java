package com.todo.business.model;

import com.todo.business.models.Todo;
import com.todo.business.models.TodoFactory;
import com.todo.business.models.TodoFactoryImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TodoTests {

    private final TodoFactory todoFactory;

    public TodoTests() {
        this.todoFactory = new TodoFactoryImpl();
    }

    @Test
    public void givenAnNameWhenItsIsValidThenItShouldPass() {
        Todo todo = todoFactory.create(1L, "Valencia", true);
        Assertions.assertThat(todo.isNameValid()).isTrue();
    }

    @Test
    public void givenAnNameWhenItsIsInValidThenItShouldPass() {
        Todo todo = todoFactory.create(1L, "testeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee", true);
        Assertions.assertThat(todo.isNameValid()).isFalse();
    }
}