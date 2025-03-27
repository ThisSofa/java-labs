package org.example.model;

import java.util.Objects;

public class Human {
    protected String lastName; // Прізвище
    protected String firstName; // Ім'я
    protected String middleName; // По батькові
    protected Gender gender; // Стать

    // Конструктор людини
    public Human(String firstName, String lastName, String middleName, Gender gender) {
        this.lastName = lastName; // Заповнюємо прізвище
        this.firstName = firstName; // Заповнюємо ім'я
        this.middleName = middleName; // Заповнюємо по батькові
        this.gender = gender; // Визначаємо стать
    }

    // Геттери
    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public Gender getGender() {
        return gender;
    }

    // Повне ім'я у класичному форматі
    public String getFullName() {
        return String.format("%s %s %s", lastName, firstName, middleName);
    }

    // Переопределение toString() для зручного виводу
    @Override
    public String toString() {
        return String.format("%s %s %s (%s)", lastName, firstName, middleName, gender);
    }

    // Переопределение equals() для корректного сравнения объектов
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return Objects.equals(lastName, human.lastName) &&
                Objects.equals(firstName, human.firstName) &&
                Objects.equals(middleName, human.middleName) &&
                gender == human.gender;
    }

    // Переопределение hashCode() для корректной работы в коллекциях
    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, middleName, gender);
    }
}
