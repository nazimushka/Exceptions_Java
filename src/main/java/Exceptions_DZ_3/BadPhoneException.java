package Exceptions_DZ_3;

public class BadPhoneException extends Exception {
    String inputString;

    public BadPhoneException() {
    }

    @Override
    public String getMessage() {
        return "Ошибка ввода номера телефона! Требуемый формат номера телефона 10 цифр без разделителей 5556667788)\n";
    }
}