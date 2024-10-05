package homework06;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString = "";

        List<Person> people = new ArrayList<>();
        List<Product> products = new ArrayList<>();

        while (!inputString.equalsIgnoreCase("end")) {
            System.out.println("Введите имя покупателя и количество денег через символ \"=\" или введите end чтобы закончить");
            inputString = scanner.nextLine();
            if (inputString.equalsIgnoreCase("end")) {
                break;
            }
            String[] inputArray = inputString.split("=");
            String name = inputArray[0].trim();
            int money = Integer.parseInt(inputArray[1].trim());
            people.add(new Person(name, money));
        }

        inputString = "";
        while (!inputString.equalsIgnoreCase("end")) {
            System.out.println("Введите название продукта и стоимость через символ \"=\" или введите end чтобы закончить");
            inputString = scanner.nextLine();
            if (inputString.equalsIgnoreCase("end")) {
                break;
            }
            String[] inputArray = inputString.split("=");
            String name = inputArray[0].trim();
            int price = Integer.parseInt(inputArray[1].trim());
            products.add(new Product(name, price));
        }

        inputString = "";
        while (!inputString.equalsIgnoreCase("end")) {
            System.out.println("Введите имя покупателя и название продукта или введите end чтобы закончить");
            inputString = scanner.nextLine();
            if (inputString.equalsIgnoreCase("end")) {
                break;
            }

            String[] inputArray = inputString.split(" ");
            String personName;
            String productName;

            if (inputArray.length == 4) {
                personName = inputArray[0].trim() + " " + inputArray[1].trim();
                productName = inputArray[2].trim() + " " + inputArray[3].trim();
            } else if (inputArray.length == 3) {
                personName = inputArray[0].trim() + " " + inputArray[1].trim();
                productName = inputArray[2].trim();
            } else {
                personName = inputArray[0].trim();
                productName = inputArray[1].trim();
            }

            for (Person person : people) {
                if (person.getName().equals(personName)) {
                    for (Product product : products) {
                        if (product.getName().equals(productName)) {
                            person.addProductToBag(product);
                            break;
                        }
                    }
                }
            }
        }

        System.out.println(people.toString().replace("[", "").replace("]", ""));
    }

}
