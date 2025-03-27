package org.example.controller;

import org.example.model.*;

public class StudentCreator {
    public static Student createStudent( String lastName, String firstName, String middleName, Gender gender) {
        return new Student(lastName, firstName, middleName, gender); ///випускаємо нового студента у дикий світ
    }
}