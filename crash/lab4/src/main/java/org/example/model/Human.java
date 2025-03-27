package org.example.model;

public class Human {
    protected String lastName; //прізвище
    protected String firstName; //ім'я
    protected String middleName; //по батькові
    protected Gender gender; //стать

    //конструктор людини
    public Human(String firstName, String lastName, String middleName, Gender gender) {
        this.lastName = lastName; //заповнюємо прізвище
        this.firstName = firstName; //заповнюємо ім'я
        this.middleName = middleName; //заповнюємо по батькові
        this.gender = gender; // хто я, президент чи домогосподарка....
    }

    // Геттеры
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

    // збирання повного імені
    public String getFullName() {
        return lastName + " " + firstName + " " + middleName; //класичний український формат
    }

    @Override
    public String toString() {
        return lastName + " " + firstName + " " + middleName + " (" + gender + ")";
    }
}
