package Exceptions_DZ_2;
// Дан следующий код, исправьте его там, где требуется

public class Task3 {
    public static void main(String[] args) throws Exception {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = { 1, 2 };
            abc[3] = 9;
        } catch (ArithmeticException ex) {  // добавлено исключение ArithmeticException для случаев деления на 0
            System.out.println("Деление на ноль не допускается!");
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (Throwable ex) {            // перемещен на последнее место, т.к. данный тип исключения самый общий
            System.out.println("Что-то пошло не так...");
        }
    }

    // FileNotFoundException заменен на NullPointerException т.к. с файлами мы здесь не работаем,
    // а вот null в качестве одного или обоих аргументов прийти может!
    public static void printSum(Integer a, Integer b) throws NullPointerException {
        System.out.println(a + b);
    }

}