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
        // Инициализация базы данных
        DatabaseManager.initDatabase();

        // Сканер для ввода месяца
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть номер місяця (1-12): ");
        int month = scanner.nextInt();

        // Получаем всех студентов из базы данных
        List<Student> allStudents = DatabaseManager.getAllStudents();

        // Указываем формат даты
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Фильтруем студентов по выбранному месяцу
        List<Student> filteredStudents = allStudents.stream()
                .filter(student -> {
                    try {
                        // Преобразуем строку в LocalDate с использованием формата
                        LocalDate birthDate = LocalDate.parse(student.getBirthDate(), formatter);
                        return birthDate.getMonthValue() == month;
                    } catch (Exception e) {
                        // Если возникла ошибка при парсинге даты, игнорируем этого студента
                        System.err.println("Помилка парсингу дати: " + student.getBirthDate());
                        return false;
                    }
                })
                .collect(Collectors.toList());

        // Выводим результат
        if (filteredStudents.isEmpty()) {
            System.out.println("Немає студентів, народжених у цьому місяці.");
        } else {
            System.out.println("Студенти, народжені у вибраному місяці:");
            filteredStudents.forEach(System.out::println);
        }
    }
}
