package Exceptions_DZ_2;

// Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
// Пользователю должно показаться сообщение, что пустые строки вводить нельзя.

import java.util.Scanner;

public class Task4 {

    private static String inputValue() {
        String res = "";
        try (Scanner inp = new Scanner(System.in)) {
            System.out.println("Введите какую-либо строку");
            res = inp.nextLine();
        }
        if (res.isEmpty()) {
            throw new RuntimeException("Ошибка ввода: введена пустая строка!");
        }
        return res;
    }
    public static void main(String[] args) {
        String input = inputValue();
        System.out.println(input);
    }
}