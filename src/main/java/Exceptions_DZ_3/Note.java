package Exceptions_DZ_3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Note {
    private String surname;
    private String name;
    private String patronimic;
    private LocalDate birthday;
    private Long phone;
    private Gender gender;

    public enum Gender {
        M, F;

        public static Gender toGender(String text) {
            switch (text) {
                case "m":
                    return Gender.M;
                case "M":
                    return Gender.M;
                case "f":
                    return Gender.F;
                case "F":
                    return Gender.F;
                default:
                    return Gender.M;
            }
        }
    }

    public Note() {

    }

    public Note(String surname, String name, String patronimic, LocalDate birthday, Long phone, Gender gender) {
        this.surname = surname;
        this.name = name;
        this.patronimic = patronimic;
        this.birthday = birthday;
        this.phone = phone;
        this.gender = gender;
    }

    public boolean equals(String surname, String name, LocalDate birthday) {
        return this.surname.equals(surname) && this.name.equals(name) && this.birthday.equals(birthday);
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surn) {
        this.surname = surn;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronimic() {
        return this.patronimic;
    }

    public void setPatronimic(String patronimic) {
        this.patronimic = patronimic;
    }

    public LocalDate getBirthday() {
        return this.birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Long getPhone() {
        return this.phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public Gender getGender() {
        return this.gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        StringBuilder sb = new StringBuilder();
        sb.append("<" + this.surname + ">");
        sb.append("<" + this.name + ">");
        sb.append("<" + this.patronimic + ">");
        sb.append("<" + df.format(this.birthday) + ">");
        sb.append("<" + this.phone + ">");
        sb.append("<" + this.gender + ">");
        sb.append("\n");
        return sb.toString();
    }
}