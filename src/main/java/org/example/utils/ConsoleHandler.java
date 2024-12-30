package org.example.utils;

import java.util.Scanner;

public class ConsoleHandler {

    private final Scanner scanner = new Scanner(System.in);

    public String getString(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    public Integer getInteger(String message) {
        while (true) {
            try {
                System.out.println(message);
                int value = scanner.nextInt();
                scanner.nextLine();
                if (value < 0) {
                    System.out.println("Ingresa un número positivo.");
                } else {
                    return value;
                }
            } catch (Exception e) {
                System.out.println("Ingresa un número con formato válido.");
                scanner.nextLine();
            }
        }
    }

    public Double getDouble(String message) {
        while (true) {
            try {
                System.out.println(message);
                double value = scanner.nextDouble();
                scanner.nextLine();
                if (value < 0) {
                    System.out.println("Ingresa un número positivo.");
                } else {
                    return value;
                }
            } catch (Exception e) {
                System.out.println("Ingresa un número con formato válido.");
                scanner.nextLine();
            }
        }
    }
}
