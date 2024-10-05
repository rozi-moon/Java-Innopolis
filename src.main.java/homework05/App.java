package homework05;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Television tv = new Television(0, "Xiaomi", 0, false);
        Television tv1 = new Television(0, "LG", 0, false);
        Television tv2 = new Television(5, "Samsung", 23, true);
        Television tv3 = new Television(0, "Sony", 0, false);
        Television tv4 = new Television(8, "LG", 48, true);
        Television tv5 = new Television(0, "Samsung", 0, false);
        Television tv6 = new Television(3, "Sony", 36, true);
        Television tv7 = new Television(7, "Xiaomi", 54, true);
        Television tv8 = new Television(10, "LG", 80, true);
        Television tv9 = new Television(0, "Sony", 0, false);

        Television[] televisions = new Television[]{tv, tv1, tv2, tv3, tv4, tv5, tv6, tv7, tv8, tv9};

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите минимальный уровень громкости:");
        int minVolume = scanner.nextInt();
        System.out.println("Введите минимальный уровень громкости:");
        int maxVolume = scanner.nextInt();

        for (int i = 0; i < televisions.length; i++) {
            if (televisions[i].getVolume() > minVolume
                    && televisions[i].getVolume() < maxVolume
                    && televisions[i].isOn()) {
                System.out.println(televisions[i].toString());
            }
        }
    }

}
