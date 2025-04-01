package org.example.model;

public class Student {
    private int id;
    private String lastName;
    private String firstName;
    private String middleName;
    private String birthDate;
    private String recordBookNumber;

    public Student(int id, String lastName, String firstName, String middleName, String birthDate, String recordBookNumber) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.recordBookNumber = recordBookNumber;
    }

    public String getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return lastName + " " + firstName + " " + (middleName != null ? middleName : "") +
                " (Дата народження: " + birthDate + ")";
    }
}