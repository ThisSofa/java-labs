package org.example.model;

public class Student extends Human {
    ///конструктор студента
    public Student(String lastName, String firstName, String middleName, Gender gender) {
        super(lastName, firstName, middleName, gender); ///передаємо всі дані батьківському класу
    }

    ///отримуємо повне ім'я студента
    public String getFullName() {
        return getLastName() + " " + getFirstName() + " " + getMiddleName(); ///формат: "Прізвище Ім'я По-батькові"
    }
}