package com.company;

public class Price {
    int rubles;
    int pennies;

    public Price(int rubles, int pennies) {
        if (rubles >= 0 && pennies >= 0 && pennies <= 99) {
            this.rubles = rubles;
            this.pennies = pennies;
        }
        else {
            System.out.println("Incorrect price");
        }
    }

    public int getRubles() {
        return rubles;
    }

    public int getPennies(){
        return pennies;
    }

    @Override
    public String toString() {
        return "" + rubles + " руб." + pennies + " коп.";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof Price))
            return false;
        Price other = (Price)obj;
        return other.rubles == rubles && other.pennies == pennies;
    }

    @Override
    public final int hashCode() {
        int result = 1;
        result = 31 * result + Integer.hashCode(rubles);
        result = 31 * result + Integer.hashCode(pennies);
        return result;
    }
}
