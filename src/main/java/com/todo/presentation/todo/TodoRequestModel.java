package com.todo.presentation.todo;

public class TodoRequestModel {
    String name;
    Boolean checked;

    public TodoRequestModel() {}

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
    public String toString() {
        return "TodoRequestModel{" + "name='" + name + '\'' + ", checked=" + checked + '}';
    }

}
