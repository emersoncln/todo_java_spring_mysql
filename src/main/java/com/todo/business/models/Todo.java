package com.todo.business.models;

public interface Todo {
    Long id = -1L;

    String name = "";
    Boolean checked = false;

    public Boolean isNameValid();
}
