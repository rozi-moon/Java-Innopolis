package homework11;

import java.util.Objects;

public class Car {

    private String carNumber;
    private String model;
    private String color;
    private Integer mileage;
    private Integer price;

    public Car(String carNumber, String model, String color, Integer mileage, Integer price) {
        this.carNumber = carNumber;
        this.model = model;
        this.color = color;
        this.mileage = mileage;
        this.price = price;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car car)) return false;
        return carNumber == car.carNumber && Objects.equals(model, car.model) && Objects.equals(color, car.color) && Objects.equals(mileage, car.mileage) && Objects.equals(price, car.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carNumber, model, color, mileage, price);
    }

    @Override
    public String toString() {
        return "Car{" +
                "carNumber=" + carNumber +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", mileage=" + mileage +
                ", price=" + price +
                '}';
    }
}
