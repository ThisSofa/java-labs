package org.example.model;

public class Professor extends Human {
    private Department department; // кафедра, на которой работает профессор

    // Конструктор профессора
    public Professor(String lastName, String firstName, String middleName, Gender gender, Department department) {
        super(firstName, lastName, middleName, gender); // передаем данные в конструктор родительского класса Human
        this.department = department; // назначаем кафедру
    }

    // Получаем кафедру профессора
    public Department getDepartment() {
        return department;
    }

    // Устанавливаем кафедру профессора
    public void setDepartment(Department department) {
        this.department = department;
    }

    // Переопределяем toString для удобного вывода информации
    @Override
    public String toString() {
        return super.toString() + ", Кафедра: " + department.getName();
    }
}
