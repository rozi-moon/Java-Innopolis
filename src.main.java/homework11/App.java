package homework11;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        List<Car> cars = new ArrayList<Car>();
        cars.add(new Car("a123me", "Mercedes", "White", 0, 8300000));
        cars.add(new Car("b873of", "Volga", "Black", 0, 673000));
        cars.add(new Car("w487mn", "Lexus", "Grey", 76000, 900000));
        cars.add(new Car("p987hj", "Volga", "Red", 610, 704340));
        cars.add(new Car("c987ss", "Toyota", "White", 254000, 761000));
        cars.add(new Car("o983op", "Toyota", "Black", 698000, 740000));
        cars.add(new Car("p146op", "BMW", "White", 271000, 850000));
        cars.add(new Car("u893ii", "Toyota", "Purple", 210900, 440000));
        cars.add(new Car("l097df", "Toyota", "Black", 108000, 780000));
        cars.add(new Car("y876wd", "Toyota", "Black", 160000, 1000000));

        String colorToFind = "Black";
        Integer zeroMileAge = 0;

        List<String> carNumbers = cars.stream()
                .filter(car -> car.getColor().equals(colorToFind) || car.getMileage().equals(zeroMileAge))
                .map(Car::getCarNumber)
                .toList();

        System.out.println(carNumbers);

        Integer minPrice = 700000;
        Integer maxPrice = 800000;

        Long countOfCars = cars.stream()
                .filter(car -> car.getPrice() >= minPrice && car.getPrice() <= maxPrice)
                .count();

        System.out.println(countOfCars);
    }

}
