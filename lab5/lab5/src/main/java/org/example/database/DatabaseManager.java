package org.example.database;

import org.example.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private static final String URL = "jdbc:postgresql://localhost:5432/students"; /// JDBC URL для підключення до PostgreSQL
    private static final String USER = "user";
    private static final String PASSWORD = "password";


    public static void initDatabase() {  /// метод для ніціалізації
        System.out.println("Шота підключилося, напевно бд");
    }


    public static List<Student> getAllStudents() { /// откримуємо усіх обовтусів з бд
        List<Student> students = new ArrayList<>(); ///створюємо новий список
        String query = "SELECT * FROM students"; // SQL-запит для отримання усіх студентів

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);  ///відкриваємо з'єднання з бд
             Statement statement = connection.createStatement(); ///виконуємо запит
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {    ///проходимося по усім строкам результата запита
                students.add(new Student(
                        resultSet.getInt("id"),
                        resultSet.getString("last_name"),
                        resultSet.getString("first_name"),
                        resultSet.getString("middle_name"),
                        resultSet.getDate("birth_date").toString(),
                        resultSet.getString("record_book_number")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace(); ///це якщо помилка буде
        }
        return students; ///видаємо що там нашреблося
    }
}
