package homework08;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Person {

    private String name;
    private int money;
    private List<Product> bag;

    public Person(String name, int money) {
        this.setName(name);
        this.setMoney(money);
        this.bag = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            System.out.println("Имя не может быть пустым");
        } else {
            this.name = name;
        }
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        if (money < 0) {
            System.out.println("Деньги немогут быть отрицательными");
            this.money = 0;
        } else {
            this.money = money;
        }
    }

    public List<Product> getBag() {
        return bag;
    }

    public void setBag(List<Product> bag) {
        this.bag = bag;
    }

    public String addProductToBag(Product product) {
        if (this.money > product.getPrice()) {
            this.bag.add(product);
            return this.name + " купил " + product.getName() + "\n";
        } else {
            return this.name + " не может позволить себе " + product.getName() + "\n";
        }
    }

    @Override
    public String toString() {
        return this.name + " - " + printProducts();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return money == person.money && Objects.equals(name, person.name) && Objects.deepEquals(bag, person.bag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, money, bag);
    }

    private String printProducts() {
        if (this.bag.isEmpty()) {
            return "Ничего не куплено\n";
        } else {
            return this.bag.toString().replace("[", "").replace("]", "") + "\n";
        }
    }
}
