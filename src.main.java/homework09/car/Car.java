package homework09.car;

import java.util.Objects;

public class Car {

    private String brand;
    private String model;
    private Integer yearOfProduction;
    private Integer enginePower;
    private Integer acceleration;
    private Integer suspension;
    private Integer durability;

    public Car(String brand, String model, Integer yearOfProduction, Integer enginePower, Integer acceleration, Integer suspension, Integer durability) {
        this.brand = brand;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.enginePower = enginePower;
        this.acceleration = acceleration;
        this.suspension = suspension;
        this.durability = durability;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(Integer yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public Integer getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(Integer enginePower) {
        this.enginePower = enginePower;
    }

    public Integer getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(Integer acceleration) {
        this.acceleration = acceleration;
    }

    public Integer getSuspension() {
        return suspension;
    }

    public void setSuspension(Integer suspension) {
        this.suspension = suspension;
    }

    public Integer getDurability() {
        return durability;
    }

    public void setDurability(Integer durability) {
        this.durability = durability;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car car)) return false;
        return Objects.equals(brand, car.brand) && Objects.equals(model, car.model) && Objects.equals(yearOfProduction, car.yearOfProduction) && Objects.equals(enginePower, car.enginePower) && Objects.equals(acceleration, car.acceleration) && Objects.equals(suspension, car.suspension) && Objects.equals(durability, car.durability);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, yearOfProduction, enginePower, acceleration, suspension, durability);
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                ", enginePower=" + enginePower +
                ", acceleration=" + acceleration +
                ", suspension=" + suspension +
                ", durability=" + durability +
                '}';
    }
}
