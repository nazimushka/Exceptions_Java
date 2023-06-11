package Exceptions_DZ_2;

// Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
// и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению
// приложения, вместо этого, необходимо повторно запросить у пользователя ввод данных.

import java.util.Scanner;

public class Task1 {

    private static Float inputValue() {
        Scanner inp = new Scanner(System.in);
        System.out.println("Введите дробное число");
        while(!inp.hasNextFloat()) {
            System.out.println("Ошибка ввода: введите дробное число");
            inp.next();
        }
        return inp.nextFloat();
    }

    public static void main(String[] args) {
        Float num = inputValue();
        System.out.println(num);
    }
}