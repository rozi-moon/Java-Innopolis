package homework08;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class App {

    private static final List<Person> PEOPLE = new ArrayList<>();
    private static final List<Product> PRODUCTS = new ArrayList<>();

    public static void main(String[] args) {

        int lineNumber = 1;
        String output = "";

        try (BufferedReader bf = new BufferedReader(new FileReader("resources/input.txt"))) {

            for (String line = bf.readLine(); line != null; line = bf.readLine()) {
                if (line.equalsIgnoreCase("end")) {
                    break;
                }

                if (lineNumber == 1) {
                    convertLineToPerson(line);
                }

                if (lineNumber == 2) {
                    convertLineToProduct(line);
                }

                if (lineNumber >= 3) {
                    output = addProductsToPeople(line, output);
                }

                lineNumber++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        writePeopleInFile(output);
    }

    private static void convertLineToPerson(String line) {
        String[] arrayOfPerson = line.split(";");
        for (String ofPerson : arrayOfPerson) {
            String[] personWithMoney = ofPerson.split("=");
            String name = personWithMoney[0].trim();
            int money = Integer.parseInt(personWithMoney[1].trim());
            PEOPLE.add(new Person(name, money));
        }
    }

    private static void convertLineToProduct(String line) {
        String[] arrayOfProducts = line.split(";");
        for (String product : arrayOfProducts) {
            String[] productWithPrice = product.split("=");
            String name = productWithPrice[0].trim();
            int price = Integer.parseInt(productWithPrice[1].trim());
            PRODUCTS.add(new Product(name, price));
        }
    }

    private static String addProductsToPeople(String line, String output) {
        String[] inputArray = line.split(" ");
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

        for (Person person : PEOPLE) {
            if (person.getName().equals(personName)) {
                for (Product product : PRODUCTS) {
                    if (product.getName().equals(productName)) {
                        output = output + person.addProductToBag(product);
                        break;
                    }
                }
            }
        }
        return output;
    }

    private static void writePeopleInFile(String output) {
        output = output.concat(System.lineSeparator());

        for (Person person : PEOPLE) {
            output = output + person.toString();
        }

        try(BufferedWriter bw = new BufferedWriter(new FileWriter("resources/output.txt"))) {
            bw.write(output);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
