package Exceptions_DZ_3;

public class BadParsingException extends Exception {

    public String message;

    public BadParsingException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

}