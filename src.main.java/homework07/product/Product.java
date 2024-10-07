package homework07.product;

import java.util.Objects;

public class Product {

    private String name;

    private int price;

    public Product(String name, int price) {
        this.setName(name);
        this.setPrice(price);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && name.matches("\\W") && name.length() > 3) {
            this.name = name;
        } else {
            System.out.println("Наименоваие продукта не должно быть пустой строкой, должно содержать буквы и быть более 3 символов в длину");
        }
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        if (price <= 0) {
            System.out.println("Цена не может быть отрицательным числом");
        } else {
            this.price = price;
        }
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return price == product.price && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
