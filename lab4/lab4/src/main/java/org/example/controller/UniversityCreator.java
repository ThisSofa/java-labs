package org.example.controller;

import org.example.model.*;

public class UniversityCreator {
    public static University createUniversity(String name, Human rector) {
        return new University(name, rector); ///заснували новий університет
    }

    public static void addFacultyToUniversity(University university, Faculty faculty) {
        university.addFaculty(faculty); ///приєднуємо факультет до університету
    }
}