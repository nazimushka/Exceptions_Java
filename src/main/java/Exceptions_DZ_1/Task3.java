package Exceptions_DZ_1;
// Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и
// возвращающий новый массив, каждый элемент которого равен разности элементов двух
// входящих массивов в той же ячейке. Если длины массивов не равны, необходимо как-то
// оповестить пользователя.

public class Task3 {

    private static int[] diff2Arrays(int[] a, int[] b) {
        int[] res = new int[a.length];
        if (a.length != b.length) {
            throw new RuntimeException("Length of input arrays are not equal!");
        } else {
            for (int i = 0; i < a.length; i++) {
                res[i] = a[i] - b[i];
            }
        }
        return res;
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d ", arr[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a = new int[] {2, 3, 5, 7, 11, 13, 17};
        int[] b = new int[] {1, 2, 3, 4, 5, 6, 7};
        int[] c = new int[] {1, 2, 3, 4, 5};
        printArray(a);
        printArray(b);
        System.out.println("Difference between array a and array b");
        printArray(diff2Arrays(a, b));
        System.out.println();
        printArray(a);
        printArray(c);
        System.out.println("Difference between array a and array c");
        printArray(diff2Arrays(a, c));
    }
}