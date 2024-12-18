package com.kpilabs;

// variant 25

// 1. Варіант завдання - Визначити клас морський човен, який складається як мінімум з 5-и полів.

// 2. Створити клас із виконавчим методом, в якому створити масив з об’єктів класу
// визначеному варіантом (п. 2). Відсортувати масив, за одним з полів за зростанням,
// а за іншим — за спаданням, використовуючи при цьому стандартні засоби сортування ().
// Після цього знайти в масиві об’єкт, який ідентичний заданому.
// Всі змінні повинні бути описані та значення їх задані у виконавчому методі.
// Код повинен бути детально задокументований.
// Код повинен відповідати стандартам Java Code Conventions (або Google Java Style Guide)
// та бути завантаженим на GitHub.

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введіть кількість морських човен: ");
            int numberOfVessels = scanner.nextInt();
            scanner.nextLine();

            if (numberOfVessels <= 0) {
                throw new IllegalArgumentException("Кількість човен повинна бути додатною.");
            }

            Boat[] boats = new Boat[numberOfVessels];

            for (int i = 0; i < numberOfVessels; i++) {
                System.out.println("\nВведення даних для човна #" + (i + 1) + ":");

                System.out.print("Назва: ");
                String name = scanner.nextLine();

                System.out.print("Тип: ");
                String type = scanner.nextLine();

                System.out.print("Довжина (в метрах): ");
                double length = scanner.nextDouble();

                System.out.print("Водотоннаж: ");
                double displacement = scanner.nextDouble();

                System.out.print("Кількість екіпажу: ");
                int crewCapacity = scanner.nextInt();
                scanner.nextLine();

                boats[i] = new Boat(name, type, length, displacement, crewCapacity);
            }

            // Сортування масиву за водотоннажем за зростанням та за довжиною за спаданням
            Arrays.sort(boats, Comparator
                    .comparingDouble(Boat::getDisplacement)
                    .thenComparing(Comparator.comparingDouble(Boat::getLength).reversed()));

            System.out.println("\nВідсортований масив кораблів за водотоннажем за зростанням та за довжиною за спаданням:");
            for (Boat boat : boats) {
                System.out.println(boat);
            }

            // Введення даних для пошуку
            System.out.println("\nВведіть дані човна для пошуку:");

            System.out.print("Назва: ");
            String targetName = scanner.nextLine();

            System.out.print("Тип: ");
            String targetType = scanner.nextLine();

            System.out.print("Довжина (в метрах): ");
            double targetLength = scanner.nextDouble();

            System.out.print("Водотоннаж: ");
            double targetDisplacement = scanner.nextDouble();

            System.out.print("Кількість екіпажу: ");
            int targetCrewCapacity = scanner.nextInt();
            scanner.nextLine();

            Boat target = new Boat(targetName, targetType, targetLength, targetDisplacement, targetCrewCapacity);

            // Пошук об'єкта в масиві
            int index = Arrays.asList(boats).indexOf(target);
            if (index != -1) {
                System.out.println("\nЗнайдено об'єкт: " + boats[index] + " на позиції " + index);
            } else {
                System.out.println("\nОб'єкт не знайдено в масиві.");
            }

        } catch (IllegalArgumentException e) {
            System.err.println("Помилка введення: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Виникла непередбачена помилка: " + e.getMessage());
        }
    }
}

