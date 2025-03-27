package org.example.model;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public String toString() {
        return "Факультет: " + name + ", Декан: " + head + ", Кафедри: " + departments;
    }
}
