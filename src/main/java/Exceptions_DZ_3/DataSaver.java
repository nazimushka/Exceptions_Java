package Exceptions_DZ_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataSaver {

    void save(Note data) throws IOException {
        if(data != null) {
            String filepath = "./Exceptions_DZ_3/Exceptions_DZ_3/Files/";
            try {
                File file = new File(filepath + data.getSurname() + ".txt");
                // проверяем есть ли файл с такой фамилией
                if (file.exists()) {
                    // проверяем, есть ли уже такая запись в файле
                    try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF8"))) {
                        String currLine;
                        while ((currLine = br.readLine()) != null) {
                            String[] nl = currLine.split("><");
                            String surname = nl[0].substring(1);
                            String name = nl[1].substring(0, nl[1].length());
                            DateTimeFormatter df = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                            LocalDate birthday = LocalDate.parse(nl[3].substring(0, nl[3].length()), df);
                            if(data.equals(surname, name, birthday)) {
                                System.out.println("Введенные Вами данные уже содержатся в файле " + surname +".txt. Хотите ввести новые данные?");
                                App.restart();
                            }
                        }
                        br.close();
                    }
                    // если такой записи в файле нет, то дописываем в конец файла
                    try (Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(
                            filepath + data.getSurname() + ".txt", true), "UTF-8"))) {
                        out.write(data.toString());
                    };

                } else {
                    // если файла с такой фамилией нет, то создаем файл и записываем в него
                    try (Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(
                            filepath + data.getSurname() + ".txt"), "UTF-8"))) {
                        out.write(data.toString());
                    };
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

}
