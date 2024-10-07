package homework09.car;

import java.util.Objects;

public class ShowCar extends Car{

    private Integer stars = 0;

    public ShowCar(String brand, String model, Integer yearOfProduction, Integer enginePower, Integer acceleration, Integer suspension, Integer durability, Integer stars) {
        super(brand, model, yearOfProduction, enginePower, acceleration, suspension, durability);
        this.stars = stars;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof ShowCar showCar)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(stars, showCar.stars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), stars);
    }

    @Override
    public String toString() {
        return "ShowCar{" +
                "stars=" + stars +
                '}';
    }
}
