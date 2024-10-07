package homework09;

import homework09.car.Car;
import homework09.car.PerformanceCar;
import homework09.car.ShowCar;
import homework09.race.CasualRace;
import homework09.race.DragRace;
import homework09.race.DriftRace;
import homework09.race.Race;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        Car car = new Car("Nissan", "GTR", 2015, 200, 100, 50, 100);
        Car car1 = new PerformanceCar("Porche", "911", 2020, 400, 200, 45, 150, new ArrayList<>());
        Car car2 = new Car("Nissan", "Skyline", 2012, 180, 100, 80, 120);
        Car car3 = new ShowCar("BMW", "M5", 2018, 140, 180, 150, 200, 4);

        Race race = new CasualRace(100, "Круг", 100000, List.of(car, car2));
        Race dragRace = new DragRace(50, "Гонка с ускорением", 2000000, List.of(car1));
        Race casualRace = new DriftRace(200, "Дрифт", 50000, List.of(car, car1, car2, car3));

        System.out.println(race);
        System.out.println(dragRace);
        System.out.println(casualRace);

        Garage garage = new Garage(List.of(car1));
        garage.modificateCar(car3, 300, 130, 100, 180);
        garage.getParkedCars().add(car3);

        System.out.println(garage);

    }

}
