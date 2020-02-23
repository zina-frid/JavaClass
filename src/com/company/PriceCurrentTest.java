package com.company;

import org.junit.Test;
import static org.junit.Assert.*;

public class PriceCurrentTest {

    @Test
    public void addProduct(){
        PriceCurrent result = new PriceCurrent();
        assertTrue(result.addProduct(18500, new Product("Book", 549.99)));
        assertTrue(result.addProduct(18501, new Product("Candle", 99.99)));
        assertTrue(result.addProduct(18502, new Product("Mirror", 999.90)));
        assertFalse(result.addProduct(18502, new Product("Paper", 4.99)));
        assertTrue(result.addProduct(18503, new Product("Rope", 14.90)));
        assertTrue(result.addProduct(18504, new Product("Soup", 79.90)));
        assertFalse(result.addProduct(18504, new Product("Spoon", 25.90)));
        assertTrue(result.addProduct(18505, new Product("Towel", 249.90)));
    }

    @Test
    public void changePrice(){
        PriceCurrent result = new PriceCurrent();
        result.addProduct(18501, new Product("Candle", 99.99));
        result.addProduct(18504, new Product("Soup", 79.90));
        result.addProduct(18505, new Product("Towel", 249.90));

        assertTrue(result.changePrice(18501, 49.90));
        assertFalse(result.changePrice(18503, 49.90));
    }

    @Test
    public void changeName(){
        PriceCurrent result = new PriceCurrent();
        result.addProduct(18501, new Product("Candle", 99.99));
        result.addProduct(18504, new Product("Soup", 79.90));
        result.addProduct(18505, new Product("Towel", 249.90));

        assertTrue(result.changeName(18501, "Rope"));
        assertFalse(result.changeName(18503, "Spoon"));
    }

    @Test
    public void removeProduct(){
        PriceCurrent result = new PriceCurrent();
        result.addProduct(18501, new Product("Candle", 99.99));
        result.addProduct(18504, new Product("Soup", 79.90));
        result.addProduct(18505, new Product("Towel", 249.90));

        assertTrue(result.removeProduct(18501));
        assertFalse(result.removeProduct(18503));
    }

    @Test
    public void finalCost(){
        PriceCurrent result = new PriceCurrent();
        result.addProduct(18501, new Product("Candle", 99.99));
        result.addProduct(18504, new Product("Soup", 79.90));
        result.addProduct(18505, new Product("Towel", 249.90));

        assertEquals(299.97, result.finalCost(18501, 3), 1e-2);
        assertNotEquals(299.97, result.finalCost(18504, 3), 1e-2);
    }
}
