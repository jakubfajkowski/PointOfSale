package main.java;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {
    private String name;
    private BigDecimal price;

    public BigDecimal getPrice() {
        return price;
    }

    public Product(String name, double price){
        this.name = name;
        this.price = new BigDecimal(price).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name);
        stringBuilder.append(' ');
        stringBuilder.append(price);
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) &&
                Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
