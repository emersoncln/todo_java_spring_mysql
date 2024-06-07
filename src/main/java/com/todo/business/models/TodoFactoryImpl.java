package com.todo.business.models;

import org.springframework.stereotype.Component;

@Component
public class TodoFactoryImpl implements TodoFactory {
    @Override
    public Todo create(Long id, String name, Boolean checked) {
        return new TodoImpl(id, name, checked);
    }
}
