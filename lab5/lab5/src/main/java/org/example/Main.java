package org.example;

import org.example.database.DatabaseManager;
import org.example.model.Student;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        DatabaseManager.initDatabase(); ///ініціалізуємо базу даних

        Scanner scanner = new Scanner(System.in); ///заводимо пилосос
        System.out.print("Введіть номер місяця (1-12): ");
        int month = scanner.nextInt(); ///пилососимо дані

        List<Student> allStudents = DatabaseManager.getAllStudents(); ///тягнема дані з бд

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); ///дата любить бути кривою
        List<Student> filteredStudents = allStudents.stream() ///фільтруємо студентів за обраним місяцем
                .filter(student -> {
                    try {
                        LocalDate birthDate = LocalDate.parse(student.getBirthDate(), formatter); ///парсинг
                        return birthDate.getMonthValue() == month; ///перевіряємо збіг місяця
                    } catch (Exception e) {
                        System.err.println("Помилка парсингу дати: " + student.getBirthDate());  ///якщо щось пішло не так (наприклад, хтось народився 32 січня)
                        return false; ///пропускаємо такого "унікума"
                    }
                })
                .collect(Collectors.toList()); ///збираємо результат у список

        if (filteredStudents.isEmpty()) { ///виводимо результат
            System.out.println("Нє, таких нєма");
        } else {
            System.out.println("Оп-оп, вполососили данні:");
            filteredStudents.forEach(System.out::println); ///виводимо всіх знайдених
        }
        scanner.close(); ///глушимо пилосос
    }
}