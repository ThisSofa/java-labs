package org.example.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    // Переопределение toString для корректного вывода
    @Override
    public String toString() {
        StringBuilder facultiesString = new StringBuilder();
        for (Faculty faculty : faculties) {
            facultiesString.append(faculty.toString()).append("\n");
        }
        return "University{name='" + name + "', rector=" + rector + ", faculties=\n" + facultiesString.toString() + "}";
    }

    // Переопределение equals для корректного сравнения объектов
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        University that = (University) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(rector, that.rector) &&
                Objects.equals(faculties, that.faculties);
    }

    // Переопределение hashCode для корректного сравнения объектов
    @Override
    public int hashCode() {
        return Objects.hash(name, rector, faculties);
    }
}
