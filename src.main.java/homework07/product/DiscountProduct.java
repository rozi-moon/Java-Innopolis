package homework07.product;

import java.util.Objects;

public class DiscountProduct extends Product{

    private int discount;
    private boolean discountIsOn;

    public DiscountProduct(String name, int price, int discount, boolean discountIsOn) {
        super(name, price);
        this.discount = discount;
        this.discountIsOn = discountIsOn;
    }

    public int getPrice() {
        if (discountIsOn) {
            return super.getPrice()/discount*100;
        }
        return super.getPrice();
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public boolean isDiscountIsOn() {
        return discountIsOn;
    }

    public void setDiscountIsOn(boolean discountIsOn) {
        this.discountIsOn = discountIsOn;
    }

    @Override
    public String toString() {
        return "DiscountProduct{" +
                "discount=" + discount +
                ", discountIsOn=" + discountIsOn +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DiscountProduct that)) return false;
        if (!super.equals(o)) return false;
        return discount == that.discount && discountIsOn == that.discountIsOn;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), discount, discountIsOn);
    }
}
