package lesson3;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Television Tv1 = new Television(1, "Samsung", "green");
        Television Tv2 = new Television(5, "Apple", "white");
        Television Tv3 = new Television(3, "Xiaomi", "black");
        System.out.println(Tv1.toString());
        System.out.println(Tv2.toString());
        System.out.println(Tv3.toString());
        Scanner sc = new Scanner(System.in);
        int channel = sc.nextInt();
        String model = sc.next();
        String color = sc.next();
        Television Tv4 = new Television(channel, model, color);
        System.out.println(Tv4.toString());


    }

}
