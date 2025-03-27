package org.example.eater;

import org.example.controller.*;
import org.example.model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AreYouOkay {
    @Test
    public void testUniversityJsonSerialization() {
        // 1. Створюємо тестовий університет
        Human rector = new Human("Олександр", "Азюковський", "Олександрович", Gender.MALE);
        University oldUniversity = UniversityCreator.createUniversity(
                "Національний технічний університет Дніпровська Політехніка",
                rector
        );

        // 2. Додаємо факультети (2 штуки)
        Human dean1 = new Human("Ірина", "Удовик", "Михайлівна", Gender.FEMALE);
        Faculty faculty1 = FacultyCreator.createFaculty("Факультет інформаційних технологій", dean1);
        UniversityCreator.addFacultyToUniversity(oldUniversity, faculty1);

        Human dean2 = new Human("Петро", "Сидоренко", "Іванович", Gender.MALE);
        Faculty faculty2 = FacultyCreator.createFaculty("Факультет машинобудування", dean2);
        UniversityCreator.addFacultyToUniversity(oldUniversity, faculty2);

        // 3. Додаємо кафедри до кожного факультету (по 2 на факультет)
        // Кафедри для першого факультету
        Human head1 = new Human("Андрій", "Мартиненко", "Анатольйович", Gender.MALE);
        Department department1 = DepartmentCreator.createDepartment("ПЗКС", head1);
        FacultyCreator.addDepartmentToFaculty(faculty1, department1);

        Human head2 = new Human("Наталія", "Коваленко", "Олегівна", Gender.FEMALE);
        Department department2 = DepartmentCreator.createDepartment("Комп'ютерні науки", head2);
        FacultyCreator.addDepartmentToFaculty(faculty1, department2);

        // Кафедри для другого факультету
        Human head3 = new Human("Віктор", "Павленко", "Сергійович", Gender.MALE);
        Department department3 = DepartmentCreator.createDepartment("Двигуни внутрішнього згоряння", head3);
        FacultyCreator.addDepartmentToFaculty(faculty2, department3);

        Human head4 = new Human("Ольга", "Шевченко", "Василівна", Gender.FEMALE);
        Department department4 = DepartmentCreator.createDepartment("Автомобілебудування", head4);
        FacultyCreator.addDepartmentToFaculty(faculty2, department4);

        // 4. Додаємо групи до кожної кафедри (по 2 на кафедру)
        // Групи для першої кафедри
        Human groupHead1 = new Human("Софія", "Шолойко", "Андріївна", Gender.FEMALE);
        Group group1 = GroupCreator.createGroup("122-21-1", groupHead1);
        DepartmentCreator.addGroupToDepartment(department1, group1);

        Human groupHead2 = new Human("Дмитро", "Іваненко", "Олександрович", Gender.MALE);
        Group group2 = GroupCreator.createGroup("122-21-2", groupHead2);
        DepartmentCreator.addGroupToDepartment(department1, group2);

        // Групи для другої кафедри
        Human groupHead3 = new Human("Анна", "Мельник", "Ігорівна", Gender.FEMALE);
        Group group3 = GroupCreator.createGroup("123-21-1", groupHead3);
        DepartmentCreator.addGroupToDepartment(department2, group3);

        Human groupHead4 = new Human("Михайло", "Петренко", "Володимирович", Gender.MALE);
        Group group4 = GroupCreator.createGroup("123-21-2", groupHead4);
        DepartmentCreator.addGroupToDepartment(department2, group4);

        // 5. Додаємо студентів до кожної групи (по 2 на групу)
        // Студенти для першої групи
        Student student1 = StudentCreator.createStudent("Іван", "Петров", "Олександрович", Gender.MALE);
        GroupCreator.addStudentToGroup(group1, student1);

        Student student2 = StudentCreator.createStudent("Олена", "Сидорова", "Ігорівна", Gender.FEMALE);
        GroupCreator.addStudentToGroup(group1, student2);

        // Студенти для другої групи
        Student student3 = StudentCreator.createStudent("Андрій", "Коваленко", "Сергійович", Gender.MALE);
        GroupCreator.addStudentToGroup(group2, student3);

        Student student4 = StudentCreator.createStudent("Наталія", "Павленко", "Андріївна", Gender.FEMALE);
        GroupCreator.addStudentToGroup(group2, student4);

        // 6. Серіалізуємо університет у JSON
        System.out.println("Оригінальний університет:");
        System.out.println(oldUniversity);
        JsonManager.saveToJson(oldUniversity);
        System.out.println("\nJSON-файл успішно збережено.");

        // 7. Десеріалізуємо університет з JSON
        University newUniversity = JsonManager.loadFromJson();
        System.out.println("\nВідновлений університет:");
        System.out.println(newUniversity);

        // 8. Перевіряємо результати
        assertNotNull(newUniversity, "Помилка: newUniversity є null");
        assertEquals(oldUniversity, newUniversity, "Університети не збігаються");
        assertEquals(oldUniversity.toString(), newUniversity.toString(), "Рядкові представлення університетів не збігаються");

        // Перевірка структури
        assertEquals(2, newUniversity.getFaculties().size(), "Кількість факультетів не збігається");
        assertEquals(2, newUniversity.getFaculties().get(0).getDepartments().size(), "Кількість кафедр на першому факультеті не збігається");
        assertEquals(2, newUniversity.getFaculties().get(0).getDepartments().get(0).getGroups().size(), "Кількість груп на першій кафедрі не збігається");
        assertEquals(2, newUniversity.getFaculties().get(0).getDepartments().get(0).getGroups().get(0).getStudents().size(), "Кількість студентів у першій групі не збігається");

        System.out.println("\nТЕСТ ПРОЙДЕНО УСПІШНО! Університети однакові.");
    }


}