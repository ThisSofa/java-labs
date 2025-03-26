package org.example.controller;

import org.example.model.*;

public class DepartmentCreator {
    public static Department createDepartment(String name, Human head) {
        return new Department(name, head); ///створюємо нову кафедру з назвою та головою
    }

    public static void addGroupToDepartment(Department department, Group group) {
        department.addGroup(group); ///додаємо групу до кафедри
    }
}