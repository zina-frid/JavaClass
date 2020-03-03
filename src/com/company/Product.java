package com.company;

public class Product {
    String name;
    Price price;

    Product(String name, Price price) {
        this.name = name;
        this.price = price;
    }

    public Price getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Price price) {
        this.price = new Price (price.getRubles(), price.getPennies());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Product) {
            Product other = (Product) obj;
            return name.equals(other.name)
                    && price.equals(other.price);
        }
        return false;
    }

    @Override
    public final int hashCode() {
        int result = 1;
        if (name != null) {
            result = 31 * result + name.hashCode();
        }
        if (price != null) {
            result = (31 * result) + price.hashCode();
        }
        return result;
    }
}