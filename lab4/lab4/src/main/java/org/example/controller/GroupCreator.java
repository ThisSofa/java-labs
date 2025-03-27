package org.example.controller;

import org.example.model.*;

public class GroupCreator {
    public static Group createGroup(String name, Human head) {
        return new Group(name, head); ///ліпимо нову группу з назвою та старостою, шоб було кому оболтусами керувати
    }

    public static void addStudentToGroup(Group group, Student student) {
        group.addStudent(student); ///запихаємо студента в групу (тепер він наш)
    }
}