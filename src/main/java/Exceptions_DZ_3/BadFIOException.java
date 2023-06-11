package Exceptions_DZ_3;

public class BadFIOException extends Exception {

    public BadFIOException() {
    }

    @Override
    public String getMessage() {
        return "Ошибка ввода ФИО. ФИО должно состоять только из букв.\n";
    }
}