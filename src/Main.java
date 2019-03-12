import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] numbers = new String[2];
        int num_sys = 10;
        boolean f;
        StringBuilder protocol = new StringBuilder();
        double result = 0;


        do {
            f = false;
            System.out.println("Выберите способ считывания данных:\n 1. Ввод с клавиатуры\n 2. Считать из файла Input.txt в папке Data\n");
            switch (scanner.nextInt()) {
                case 1:
                    System.out.println("Введите первое число  ");
                    scanner.nextLine();
                    numbers[0] = scanner.nextLine();
                    System.out.println("Введите второе число  ");
                    numbers[1] = scanner.nextLine();
                    protocol.append("С консоли считаны числа ").append(numbers[0]).append(" и ").append(numbers[1]).append("\n");
                    break;
                case 2:
                    numbers = Methods.readFromFile();
                    protocol.append("С файла считаны числа ").append(numbers[0]).append(" и ").append(numbers[1]).append("\n");
                    break;
                default:
                    System.out.println("Введены неверные данные");
                    f = true;
                    break;
            }
        } while (f);

        do {
            f = false;
            System.out.println("Выберите систему счисления:\n 1. Двоичная\n 2. Восмеричная\n 3. Десятичная\n 4. Шеснадцатиричная\n");
            switch (scanner.nextInt()) {
                case 1:
                    num_sys = 2;
                    protocol.append("Выбрана двоичная система счисления\n");
                    break;
                case 2:
                    num_sys = 8;
                    protocol.append("Выбрана восмеричная система счисления\n");
                    break;
                case 3:
                    num_sys = 10;
                    protocol.append("Выбрана десятичная система счисления\n");
                    break;
                case 4:
                    num_sys = 16;
                    protocol.append("Выбрана шеснадцатиричная система счисления\n");
                    break;
                default:
                    System.out.println("Введены неверные данные");
                    f = true;
                    break;
            }
        } while (f);

        System.out.println("Введите точность вычислений (число знаков после запятой)");
        int numbersOfFraction = scanner.nextInt();

        double num1 = Methods.stringToNumber(numbers[0], num_sys);
        double num2 = Methods.stringToNumber(numbers[1], num_sys);

        do {
            f = false;
            System.out.println("Выберите действие:\n 1. Сложение (+)\n 2. Вычитание (-)\n 3. Умножение (*)\n 4. Деление (/)\n");
            switch (scanner.nextInt()) {
                case 1:
                    result = num1 + num2;
                    protocol.append("Выбрано сложение\n");
                    break;
                case 2:
                    result = num1 - num2;
                    protocol.append("Выбрано вычитание\n");
                    break;
                case 3:
                    result = num1 * num2;
                    protocol.append("Выбрано умножение\n");
                    break;
                case 4:
                    result = num1 / num2;
                    protocol.append("Выбрано деление\n");
                    break;
                default:
                    System.out.println("Введены неверные данные");
                    f = true;
                    break;
            }
        } while (f);

        System.out.println("Результат вычисления: " + Methods.numberToString(result, num_sys, numbersOfFraction));
        protocol.append("Результат вычисления: ").append(Methods.numberToString(result, num_sys, numbersOfFraction)).append("\n");
        protocol.append("Программа завершила свою работу");

        Methods.toProtocol(protocol.toString().split("\n"));
    }
}
