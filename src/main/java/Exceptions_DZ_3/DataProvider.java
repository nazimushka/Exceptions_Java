package Exceptions_DZ_3;

import java.util.Scanner;

public class DataProvider {

    private Scanner inp;
    private String inputStr;

    public DataProvider() {
        enterData();
    }

    public String getData() {
        return this.inputStr;
    }

    public void enterData() {
        System.out.println("Введите Ваши данные через пробел в формате: \nФамилия Имя Отчество ДатаРождения (дд.мм.гггг) НомерТелефона(только цифры) Пол(M или F)");
        inp = new Scanner(System.in, "IBM866");
        this.inputStr = inp.nextLine();
        if (this.inputStr.equals("") || this.inputStr.equals(null)) {
            System.out.println("Ошибка ввода данных! Попробуйте еще раз!");
            enterData();
        } else {
            this.inputStr = inputStr.replaceAll("\\s+", " ");
        }
    }

}