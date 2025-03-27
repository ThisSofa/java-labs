package org.example.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Department {
    private String name; //назва кафедри
    private Human head; //голова кафедри
    private List<Group> groups; //список груп

    //конструктор кафедри
    public Department(String name, Human head) {
        this.name = name; //задаємо горду назву
        this.head = head; //призначаємо керівника
        this.groups = new ArrayList<>(); //створюємо пустий список груп (потім заповнимо)
    }

    //додаємо групу до кафедри
    public void addGroup(Group group) {
        groups.add(group);
    }

    //дістаємо назву кафедри
    public String getName() {
        return name;
    }

    //отримуємо керівника кафедри
    public Human getHead() {
        return head;
    }

    //отримуємо всі групи кафедри
    public List<Group> getGroups() {
        return groups;
    }

    // Переопределение toString для корректного отображения кафедры и ее групп
    @Override
    public String toString() {
        return "Кафедра: " + name + ", Завідувач: " + head + ", Групи: " + groups;
    }

    // Переопределение equals для корректного сравнения объектов
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(head, that.head) &&
                Objects.equals(groups, that.groups);
    }

    // Переопределение hashCode для корректного сравнения объектов
    @Override
    public int hashCode() {
        return Objects.hash(name, head, groups);
    }
}
