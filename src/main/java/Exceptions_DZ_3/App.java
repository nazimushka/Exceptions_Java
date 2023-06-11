package Exceptions_DZ_3;

import java.io.IOException;
import java.util.Scanner;

public class App {

    public static void start() throws IOException {
        System.out.println("Эта программа умеет записывать и хранить данные обо всех!");
        DataProvider dprov = new DataProvider();
        DataParser dparse = new DataParser(dprov.getData());
        dparse.parseData();
        Note nt = new Note();
        nt.setSurname(dparse.getSurname());
        nt.setName(dparse.getName());
        nt.setPatronimic(dparse.getPatronymic());
        nt.setBirthday(dparse.getBirthday());
        nt.setPhone(dparse.getPhone());
        nt.setGender(dparse.getGender());
        DataSaver ds = new DataSaver();
        ds.save(nt);
        restart();
    }

    public static void restart() throws IOException {
        System.out.println("Для ввода новых данных введите 1. Для выхода из программы введите 0.");
        try (Scanner inp = new Scanner(System.in)) {
            String key = inp.next();
            switch (key) {
                case "0":
                    System.exit(0);
                case "1":
                    App.start();
                    break;
                default:
                    System.out.println("Нет такой команды!");
                    restart();
                    break;
            }
        }
    }

}