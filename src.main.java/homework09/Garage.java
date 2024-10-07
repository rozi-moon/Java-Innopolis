package homework09;

import homework09.car.Car;

import java.util.List;
import java.util.Objects;

public class Garage {

    private List<Car> parkedCars;

    public Garage(List<Car> parkedCars) {
        this.parkedCars = parkedCars;
    }

    public List<Car> getParkedCars() {
        return parkedCars;
    }

    public void setParkedCars(List<Car> parkedCars) {
        this.parkedCars = parkedCars;
    }

    public Car modificateCar(Car car, Integer enginePower, Integer acceleration, Integer suspension, Integer durability) {
        car.setEnginePower(enginePower);
        car.setAcceleration(acceleration);
        car.setSuspension(suspension);
        car.setDurability(durability);
        return car;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Garage garage)) return false;
        return Objects.equals(parkedCars, garage.parkedCars);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(parkedCars);
    }

    @Override
    public String toString() {
        return "Garage{" +
                "parkedCars=" + parkedCars +
                '}';
    }
}
