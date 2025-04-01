package org.example.controller;

import org.example.model.*;

public class DepartmentCreator {
    ///метод для створення нової кафедри
    public static Department createDepartment(String name, Human head) {
        return new Department(name, head); ///повертаємо свіженьку кафедру з назвою та керівником
    }

    ///метод для приєднання групи до кафедри
    public static void addGroupToDepartment(Department department, Group group) {
        department.addGroup(group); ///група тепер офіційно прикріплена до кафедри
    }
}