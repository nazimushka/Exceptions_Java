package Exceptions_DZ_2;

// Если необходимо, исправьте данный код

public class Task2 {

    private static void divCalc(Integer[] intArray) {
        try {
            int d = 0;
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        } catch (NullPointerException e) {              // добавлено исключение если один из аргументов равен null
            System.out.println("Catching exception: " + e);
        } catch (ArrayIndexOutOfBoundsException e) {    // добавлено исключение если intArray содержит менее 9 элементов
            System.out.println("Catching exception: " + e);
        }
    }
    public static void main(String[] args) {
        Integer[] arr1 = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Integer[] arr2 = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8};
        Integer[] arr3 = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, null};
        divCalc(arr1);
        divCalc(arr2);
        divCalc(arr3);
    }

}