package Exceptions_DZ_3;

public class BadGenderException extends Exception {
    String inputString;

    public BadGenderException() {
    }

    @Override
    public String getMessage() {
        return "Неправильно указан пол (должны использоваться только символы f или m)\n";
    }
}