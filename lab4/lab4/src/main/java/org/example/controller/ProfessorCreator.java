package org.example.controller;

import org.example.model.*;

public class ProfessorCreator {
    public static Professor createProfessor(String lastName, String firstName, String middleName, Gender gender, Department department) {
        return new Professor(lastName, firstName, middleName, gender, department); // создаем нового профессора
    }
}
