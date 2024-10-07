package homework09.car;

import java.util.List;
import java.util.Objects;

public class PerformanceCar extends Car {

    private List<String> addons;

    public PerformanceCar(String brand, String model, Integer yearOfProduction, Integer enginePower, Integer acceleration, Integer suspension, Integer durability, List<String> addons) {
        super(brand, model, yearOfProduction, enginePower * 150 / 100 , acceleration, suspension * 75 / 100, durability);
        this.addons = addons;
    }

    public List<String> getAddons() {
        return addons;
    }

    public void setAddons(List<String> addons) {
        this.addons = addons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PerformanceCar that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(addons, that.addons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), addons);
    }

    @Override
    public String toString() {
        return "PerformanceCar{" +
                "addons=" + addons +
                '}';
    }
}
