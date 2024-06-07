package com.todo.presentation.todo;

public class TodoResponseModel {

    Long id;
    String name;
    Boolean checked;

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

    public TodoResponseModel() {}

    @Override
    public String toString() {
        return "TodoResponseModel{" + "id=" + id + ", name='" + name + '\'' + ", checked=" + checked + '}';
    }

}
