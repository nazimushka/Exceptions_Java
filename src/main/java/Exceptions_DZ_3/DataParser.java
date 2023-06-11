package Exceptions_DZ_3;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import Exceptions_DZ_3.Note.Gender;

public class DataParser {

    private String[] splitStr;
    private String name;
    private String surname;
    private String patronymic;
    private LocalDate birthday;
    private Long phone;
    private Gender gender;

    public DataParser(String inpData) throws IOException {
        if (inpData == null) {
            throw new NullPointerException("Данные отсутствуют");
        }
        this.splitStr = inpData.split(" ");
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getPatronymic() {
        return this.patronymic;
    }

    public LocalDate getBirthday() {
        return this.birthday;
    }

    public Long getPhone() {
        return this.phone;
    }

    public Gender getGender() {
        return this.gender;
    }

    public void parseData() throws IOException {
        switch (itemCounter(this.splitStr)) {
            case -1: {
                System.out.println("Ошибка ввода: введено недостаточное количество данных!");
                App.restart();
            }
            case 1: {
                System.out.println("Ошибка ввода: слишком большое количество данных!");
                App.restart();
            }
            default: {
                try {
                    CheckData(this.splitStr);
                } catch (BadParsingException e) {
                    e.getMessage();
                }
            }
        }
    }

    public Integer itemCounter(String[] input) {
        int code = 0;
        if (input.length < 6) {
            code = -1;
        } else if (input.length > 6) {
            code = 1;
        }
        return code;        // code 0 если с количеством данных всё хорошо
    }

    public void CheckData(String[] splitedStr) throws BadParsingException {
        if (splitedStr == null) {
            throw new NullPointerException("Данные отсутствуют");
        }
        StringBuilder errCollector = new StringBuilder();
        for (String item : splitedStr) {
            if (Character.isLetter(item.charAt(0))) {
                if (item.length() == 1) {
                    if (this.gender == null) {
                        try {
                            this.gender = checkGender(item);
                        } catch (BadGenderException e) {
                            errCollector.append(e.getMessage());
                        }
                    } else {
                        errCollector.append("Ошибка ввода пола\n");
                    }
                } else {
                    if (this.surname == null) {
                        try {
                            this.surname = checkFIO(item);
                        } catch (BadFIOException e) {
                            errCollector.append(e.getMessage());
                        }
                    } else if (this.name == null) {
                        try {
                            this.name = checkFIO(item);
                        } catch (BadFIOException e) {
                            errCollector.append(e.getMessage());
                        }
                    } else if (this.patronymic == null) {
                        try {
                            this.patronymic = checkFIO(item);
                        } catch (BadFIOException e) {
                            errCollector.append(e.getMessage());
                        }
                    } else {
                        errCollector.append("Ошибка ввода ФИО.\n");
                    }
                }
            } else {
                if (item.matches("[0-9]{2}\\.[0-9]{2}\\.[0-9]{4}")) {
                    if (this.birthday == null) {
                        try {
                            this.birthday = checkBirthday(item);
                        } catch (BadBirthdayException e) {
                            errCollector.append(e.getMessage());
                        }
                    } else {
                        errCollector.append("Ошибка ввода даты рождения\n");
                    }
                } else {
                    if (this.phone == null) {
                        try {
                            this.phone = checkPhoneNumber(item);
                        } catch (BadPhoneException e) {
                            errCollector.append(e.getMessage());
                        }
                    } else {
                        errCollector.append("Ошибка ввода номера телефона\n");
                    }
                }

            }
        }
        if (errCollector.length() > 0) {
            throw new BadParsingException(errCollector.toString());
        }
    }

    public String getLastName() {
        return surname;
    }

    private String checkFIO(String inputString) throws BadFIOException {
        if (inputString.toLowerCase().matches("^[a-zа-яё]*$")) {
            return inputString;
        } else {
            throw new BadFIOException();
        }
    }

    private Long checkPhoneNumber(String inpuString) throws BadPhoneException {
        if (inpuString.length() >= 4 && inpuString.length() <= 10) {
            try {
                return Long.parseLong(inpuString);
            } catch (NumberFormatException e) {
                throw new BadPhoneException();
            }
        } else {
            throw new BadPhoneException();
        }
    }

    private Gender checkGender(String inputString) throws BadGenderException {
        try {
            return Gender.toGender(inputString);
        } catch (IllegalArgumentException e) {
            throw new BadGenderException();
        }
    }

    private LocalDate checkBirthday(String inputString) throws BadBirthdayException {
        try {
            return LocalDate.parse(inputString, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        } catch (DateTimeParseException e) {
            throw new BadBirthdayException();
        }
    }

}
