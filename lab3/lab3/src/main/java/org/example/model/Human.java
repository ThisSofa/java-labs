package org.example.model;

public class Human {
    protected String lastName; ///прізвище
    protected String firstName; ///ім'я
    protected String middleName; ///по батькові
    protected Gender gender; ///стать

    ///конструктор людини
    public Human(String firstName, String lastName, String middleName, Gender gender) {
        this.lastName = lastName; ///заповнюємо прізвище
        this.firstName = firstName; ///заповнюємо ім'я
        this.middleName = middleName; ///заповнюємо по батькові
        this.gender = gender; /// хто я, президент чи домогосподарка....
    }

    ///отримуємо прізвище
    public String getLastName() {
        return lastName;
    }

    ///отримуємо ім'я
    public String getFirstName() {
        return firstName;
    }

    ///отримуємо по батькові
    public String getMiddleName() {
        return middleName;
    }

    ///хто ти, воїн?
    public Gender getGender() {
        return gender;
    }

    ///збираємо повне ім'я
    public String getFullName() {
        return lastName + " " + firstName + " " + middleName; ///класичний український формат
    }
}