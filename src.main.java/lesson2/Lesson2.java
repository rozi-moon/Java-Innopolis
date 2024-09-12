package lesson2;
import java.util.Scanner;
public class Lesson2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        Integer sum = a + b;
        int minus = a - b;
        int mult = a * b;
        int mean = (a + b) / 2;
        int distant = a - b;
        int max = Math.max(a, b);
        int min = Math.max(a, b);
                System.out.println(
                        "Сумма двух целых чисел: " + sum +
                        "\nРазница двух целых чисел: " + minus +
                        "\nПроизведение из двух целых чисел: " + mult +
                        "\nСреднее из двух целых чисел: " + mean +
                        "\nРасстояние двух целых чисел: " + distant +
                        "\nМаксимальное целое число: " + max +
                        "\nМинимальное целое число: " + min );





    }
}