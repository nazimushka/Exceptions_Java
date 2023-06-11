package Exceptions_DZ_1;
// Реализуйте 3 метода, чтобы в каждом из них получить разные исключения

import java.io.File;
import java.io.FileReader;
import java.util.Collections;
import java.util.List;

public class Task1 {


    // генерируем FileNotFoundException
    private static void openFile() {
        try {
            File file = new File("1input.txt");
            FileReader fr = new FileReader(file);
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // генерируем UnsupportedOperationException
    private static void addValue(int value) {
        List<Integer> mylist = Collections.emptyList();
        mylist.add(value);
    }
    // генерируем ClassNotFoundException
    private static void loadClass() {
        try {
            Class.forName("wewewe");
            ClassLoader.getSystemClassLoader().loadClass("wewewe");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        loadClass();
        openFile();
        addValue(5);

    }
}