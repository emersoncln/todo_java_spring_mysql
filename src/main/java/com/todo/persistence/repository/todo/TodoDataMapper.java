package com.todo.persistence.repository.todo;

import jakarta.persistence.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Objects;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "todos")
public class TodoDataMapper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    Long id = -1L;

    @Column(name = "NAME", nullable = false, length = 100)
    String name = "";

    @Column(name = "CHECKED")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TodoDataMapper that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(checked, that.checked);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, checked);
    }

    @Override
    public String toString() {
        return "TodoDataMapper{" + "id=" + id + ", name='" + name + '\'' + ", checked=" + checked + '}';
    }

}
