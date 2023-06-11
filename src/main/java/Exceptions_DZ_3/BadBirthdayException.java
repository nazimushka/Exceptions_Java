package Exceptions_DZ_3;

public class BadBirthdayException extends Exception {

    public BadBirthdayException() {

    }

    @Override
    public String getMessage() {
        return "Ошибка ввода даты рождения! Требуемый формат дд.мм.гггг\n";
    }

}