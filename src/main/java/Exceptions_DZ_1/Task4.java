package Exceptions_DZ_1;
// Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и
// возвращающий новый массив, каждый элемент которого равен частному элементов двух
// входящих массивов в той же ячейке. Если длины массивов не равны, необходимо как-то
// оповестить пользователя. Важно: При выполнении метода единственное исключение,
// которое пользователь может увидеть - RuntimeException, т.е. ваше

public class Task4 {

    private static double[] div2Arrays(int[] a, int[] b) {
        double[] res;
        if (a.length != b.length) {
            throw new RuntimeException("Length of input arrays are not equal!");

        } else {
            res = new double[a.length];
            for (int i = 0; i < a.length; i++) {
                if (b[i] == 0) {
                    throw new RuntimeException("Error: an element of the second array equals zero, division operation is not allowed!");
                } else {
                    res[i] = (double)a[i] / (double)b[i];
                }
            }
        }
        return res;
    }

    private static void printIntArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d ", arr[i]);
        }
        System.out.println();
    }

    private static void printDoubleArray(double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%.2f ", arr[i]);
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] a = new int[] {2, 3, 5, 7, 11, 13, 17};
        int[] b = new int[] {1, 2, 3, 4, 5, 6, 7};
        int[] c = new int[] {1, 2, 3, 4, 5};
        printIntArray(a);
        printIntArray(b);
        System.out.println("Result of division array a by array b is:");
        printDoubleArray(div2Arrays(a, b));
        System.out.println();
        printIntArray(a);
        printIntArray(c);
        System.out.println("Result of division array a by array c is:");
        printDoubleArray(div2Arrays(a, c));
    }
}