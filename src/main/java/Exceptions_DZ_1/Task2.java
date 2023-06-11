package Exceptions_DZ_1;

// Посмотрите на код, и подумайте сколько разных типов исключений вы тут сможете получить?

// Ответ: можно получить следующие исключения:
//1. ArrayIndexOutOfBoundsException если в метод будет передан массив с количеством столбцов менее 5
//2. NumberFormatException если среди элементов двумерного строкового массива есть null или символы, которые нельзя конверировать в целое число
//3. NullPointerException если вместо двумерного строкового массива в метод будет передан null

public class Task2 {

    public static int sum2d(String[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 5; j++) {
                int val = Integer.parseInt(arr[i][j]);
                sum += val;
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        String[][] arr1 = { {"19999900009999", "2", "2", "2", "2"}, {"3", "4", "2", "2", "2"} };
        String[][] arr2 = { {"s", "2"}, {"3", "4"} };
        String[][] arr3 = { {null, null}, {"3", "4"} };
        String[][] arr4 = null;

        System.out.println(sum2d(arr1));
        System.out.println(sum2d(arr2));
        System.out.println(sum2d(arr3));
        System.out.println(sum2d(arr4));

    }


}