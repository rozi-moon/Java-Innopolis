package homework09.race;

import homework09.car.Car;

import java.util.List;
import java.util.Objects;

public class Race {

    private Integer length;
    private String route;
    private Integer prizeFund;
    private List<Car> members;

    public Race(Integer length, String route, Integer prizeFund, List<Car> members) {
        this.length = length;
        this.route = route;
        this.prizeFund = prizeFund;
        this.members = members;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public Integer getPrizeFund() {
        return prizeFund;
    }

    public void setPrizeFund(Integer prizeFund) {
        this.prizeFund = prizeFund;
    }

    public List<Car> getMembers() {
        return members;
    }

    public void setMembers(List<Car> members) {
        this.members = members;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Race race)) return false;
        return Objects.equals(length, race.length) && Objects.equals(route, race.route) && Objects.equals(prizeFund, race.prizeFund) && Objects.equals(members, race.members);
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, route, prizeFund, members);
    }

    @Override
    public String toString() {
        return "Race{" +
                "length=" + length +
                ", route='" + route + '\'' +
                ", prizeFund=" + prizeFund +
                ", members=" + members +
                '}';
    }
}
