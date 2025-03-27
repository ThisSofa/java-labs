package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private String name; //назва групи
    private Human head; //староста
    private List<Student> students; //студенти

    //конструктор групи
    public Group(String name, Human head) {
        this.name = name; //даємо ім'я
        this.head = head; //обрали старосту
        this.students = new ArrayList<>(); //поки що пустий список
    }

    //додаємо студента до групи (він тепер один з наших)
    public void addStudent(Student student) {
        students.add(student);
    }

    //отримуємо назву групи
    public String getName() {
        return name;
    }

    //отримуємо список студентів
    public List<Student> getStudents() {
        return students;
    }

    @Override
    public String toString() {
        return "Група: " + name + ", Куратор: " + head + ", Студенти: " + students;
    }
}
