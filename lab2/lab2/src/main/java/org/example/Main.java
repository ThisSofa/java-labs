package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final int MAX_SIZE = 20; ///задаємо обмеження розміру матриці
    private static final int MIN_RANDOM = -100; ///мінімальне значення значення
    private static final int MAX_RANDOM = 100;  ///максимальне значення значення

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); ///пилососимо значення з клавіатури
        System.out.print("Яка висота матриці(1-20): ");
        int rows = validateInput(scanner); ///валідуємо, чи належить число проміжку 1-20 через метод

        System.out.print("Яка ширина матриці (1-20): ");
        int cols = validateInput(scanner); ///валідуємо, чи належить число проміжку 1-20 через метод

        int[][] matrix = new int[rows][cols]; ///будуємо матрицю

        System.out.print("Як заповнити? (1 - вручну, 2 - рандомно): ");
        int choice = scanner.nextInt(); ///пилососимо значення, уведенне з клавіатури

        if (choice == 1) {
            fillMatrixManually(matrix, scanner); ///якщо 1, то заповнення вручну
        } else if (choice == 2) {
            fillMatrixRandomly(matrix); ///якщо 2, заповнення рандомно
        } else {
            System.out.println("Некоректний вибір! Завершення програми."); ///якщо ввели щось не те
            return;
        }

        printMatrix(matrix); ///виводимо матрицю через метод

        System.out.println("Мінімальний елемент: " + findMin(matrix)); ///викликаємо створені методи
        System.out.println("Максимальний елемент: " + findMax(matrix));
        System.out.println("Середнє арифметичне: " + calculateArithmeticMean(matrix));
        System.out.println("Середнє геометричне: " + calculateGeometricMean(matrix));

        scanner.close(); ///закриваємо Scanner, бо буде забагато пилососити
    }

    private static int validateInput(Scanner scanner) {  ///метод валідації
        int num;
        do {
            num = scanner.nextInt(); ///пилососимо число з клави
            if (num < 1 || num > MAX_SIZE) { ///якщо не 1-20, просимо ввести ще раз
                System.out.print("Неправильне значення. Введіть число від 1 до 20: ");
            }
        } while (num < 1 || num > MAX_SIZE); ///крутимо, поки не буде норм число
        return num; ///повертаємо правильне число
    }

    private static void fillMatrixManually(int[][] matrix, Scanner scanner) {  ///метод заповнення ручками
        System.out.println("Введіть елементи матриці:");
        for (int i = 0; i < matrix.length; i++) { ///проходимо по рядках
            for (int j = 0; j < matrix[i].length; j++) { ///проходимо по стовпцях
                System.out.printf("Елемент [%d][%d]: ", i, j);
                matrix[i][j] = scanner.nextInt(); ///уводимо число в конкретну клітинку
            }
        }
    }

    private static void fillMatrixRandomly(int[][] matrix) {  ///метод заповнення рандомайзером
        Random random = new Random(); ///генератор випадкових чисел
        for (int i = 0; i < matrix.length; i++) { ///проходимо по рядках
            for (int j = 0; j < matrix[i].length; j++) { ///проходимо по стовпцях
                matrix[i][j] = random.nextInt(MAX_RANDOM - MIN_RANDOM + 1) + MIN_RANDOM; ///закидуємо рандом
            }
        }
    }

    private static void printMatrix(int[][] matrix) {  ///метод виводу матриці на екран
        System.out.println("Матриця:");
        for (int[] row : matrix) { ///беремо кожен рядок
            for (int num : row) { ///беремо кожен елемент
                System.out.printf("%5d", num); ///виводимо з вирівнюванням, щоб було гарно
            }
            System.out.println(); ///переносимо на новий рядок
        }
    }

    private static int findMin(int[][] matrix) {  /// метод пошуку найменшого числа
        int min = matrix[0][0]; ///вважаємо перший елемент мінімальним
        for (int[] row : matrix) { ///проходимо по рядках
            for (int num : row) { ///проходимо по числах
                if (num < min) { ///якщо знайшли менше - зберігаємо
                    min = num;
                }
            }
        }
        return min;
    }

    private static int findMax(int[][] matrix) {   /// метод пошуку найбільшого числа
        int max = matrix[0][0]; ///вважаємо перший елемент максимальним
        for (int[] row : matrix) { ///проходимо по рядках
            for (int num : row) { ///проходимо по числах
                if (num > max) { ///якщо знайшли більше - зберігаємо
                    max = num;
                }
            }
        }
        return max;
    }

    private static double calculateArithmeticMean(int[][] matrix) {  /// метод розрахунку середнього арифметичного
        double sum = 0;
        int count = 0;
        for (int[] row : matrix) { ///проходимо по рядках
            for (int num : row) { ///проходимо по числах
                sum += num; ///накопичуємо суму
                count++; ///рахуємо кількість чисел
            }
        }
        return sum / count; ///ділимо суму на кількість чисел, отримуємо середнє арифметичне
    }

    private static double calculateGeometricMean(int[][] matrix) {  ///метод розрахунку середнього геометричного
        double product = 1;
        int count = 0;
        for (int[] row : matrix) { ///проходимо по рядках
            for (int num : row) { ///проходимо по числах
                product *= Math.abs(num) > 0 ? Math.abs(num) : 1; ///перемножуємо числа, уникаючи 0
                count++; ///рахуємо кількість чисел
            }
        }
        return Math.pow(product, 1.0 / count); ///беремо корінь n-го ступеня
    }
}
