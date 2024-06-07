package com.todo.persistence.service.todo;

import java.util.ArrayList;
import java.util.Objects;

public class TodoDsModel {
    Long id = -1L;
    String name = "";
    Boolean checked = false;

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

    public TodoDsModel() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TodoDsModel that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(checked, that.checked);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, checked);
    }

    @Override
    public String toString() {
        return "TodoDsModel{" + "id=" + id + ", name='" + name + '\'' + ", checked=" + checked + '}';
    }

}
