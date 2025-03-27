package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class University {
    private String name; ///назва університету
    private Human rector; ///ректор (найголовніший начальник)
    private List<Faculty> faculties; ///факультети

    ///конструктор університету
    public University(String name, Human rector) {
        this.name = name; ///призначаємо назву
        this.rector = rector; ///призначаємо головнокомандувача
        this.faculties = new ArrayList<>(); ///створюємо список факультетів (поки що пустий)
    }

    ///отримуємо назву університету (для офіційних папірців)
    public String getName() {
        return name;
    }

    ///отримуємо ректора
    public Human getRector() {
        return rector;
    }

    ///отримуємо список факультетів
    public List<Faculty> getFaculties() {
        return faculties;
    }

    ///додаємо новий факультет
    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }
}