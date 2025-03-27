package org.example.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Faculty {
    private String name; //назва факультету
    private Human head; //володар факультету (декан)
    private List<Department> departments; //список кафедр

    //конструктор факультету
    public Faculty(String name, Human head) {
        this.name = name; //задаємо назву
        this.head = head; //призначаємо декана
        this.departments = new ArrayList<>(); //створюємо список кафедр (поки що пустий)
    }

    //додаємо нову кафедру
    public void addDepartment(Department department) {
        departments.add(department);
    }

    //отримуємо назву факультету
    public String getName() {
        return name;
    }

    //отримуємо декана
    public Human getHead() {
        return head;
    }

    //отримуємо всі кафедри
    public List<Department> getDepartments() {
        return departments;
    }

    // Переопределение toString для корректного отображения факультета и его кафедр
    @Override
    public String toString() {
        return "Факультет: " + name + ", Декан: " + head + ", Кафедри: " + departments;
    }

    // Переопределение equals для корректного сравнения объектов
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return Objects.equals(name, faculty.name) &&
                Objects.equals(head, faculty.head) &&
                Objects.equals(departments, faculty.departments);
    }

    // Переопределение hashCode для корректного сравнения объектов
    @Override
    public int hashCode() {
        return Objects.hash(name, head, departments);
    }
}
