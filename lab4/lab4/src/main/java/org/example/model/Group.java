package org.example.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    // Переопределение toString для корректного отображения группы, старосты и студентов
    @Override
    public String toString() {
        return "Група: " + name + ", Куратор: " + head + ", Студенти: " + students;
    }

    // Переопределение equals для корректного сравнения объектов
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(name, group.name) &&
                Objects.equals(head, group.head) &&
                Objects.equals(students, group.students);
    }

    // Переопределение hashCode для корректного сравнения объектов
    @Override
    public int hashCode() {
        return Objects.hash(name, head, students);
    }
}
