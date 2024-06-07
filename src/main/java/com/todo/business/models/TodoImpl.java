package com.todo.business.models;

public class TodoImpl implements Todo {
    Long id;
    String name;
    Boolean checked;

    public TodoImpl(Long id, String name, Boolean checked) {
        this.id = id;
        this.name = name;
        this.checked = checked;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }
    @Override
    public Boolean isNameValid() {
        return name.length() <= 100;
    }
}
