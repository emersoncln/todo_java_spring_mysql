package com.todo.business.models;

public interface TodoFactory {
    public Todo create(Long id, String name, Boolean checked);
}
