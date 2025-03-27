package org.example.model;

public class Student extends Human {
    // Конструктор студента
    public Student(String lastName, String firstName, String middleName, Gender gender) {
        super(firstName, lastName, middleName, gender); // передаємо всі дані батьківському класу
    }

    // Здесь мы не переопределяем getFullName(), так как он уже есть в родительском классе.
    // Можем использовать его в этом классе напрямую.

    // Пример добавления дополнительных методов для студента
    public String getStudentInfo() {
        return "Студент: " + getFullName() + ", Стать: " + getGender();
    }
}
