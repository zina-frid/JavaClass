package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class PriceCurrentTest {

    @Test
    public void addProduct(){
        PriceCurrent result = new PriceCurrent();

        assertTrue(result.addProduct(18500, new Product("Book", new Price(549, 99))));
        assertTrue(result.addProduct(18501, new Product("Candle", new Price (99,99))));
        assertTrue(result.addProduct(18502, new Product("Mirror", new Price (999,90))));
        assertFalse(result.addProduct(18502, new Product("Paper", new Price (4,99))));
        assertTrue(result.addProduct(18503, new Product("Rope", new Price (14,90))));
        assertTrue(result.addProduct(18504, new Product("Soup", new Price (79,90))));
        assertFalse(result.addProduct(18504, new Product("Spoon", new Price (25,90))));
        assertTrue(result.addProduct(18505, new Product("Towel", new Price (249,90))));
    }

    @Test
    public void changePrice(){
        PriceCurrent OldResult = new PriceCurrent();
        PriceCurrent NewResult = new PriceCurrent();

        OldResult.addProduct(18501, new Product("Candle", new Price (99,99)));
        OldResult.addProduct(18504, new Product("Soup", new Price (79,90)));
        OldResult.addProduct(18505, new Product("Towel", new Price (249,90)));
        NewResult.addProduct(18501, new Product("Candle", new Price (99,99)));
        NewResult.addProduct(18504, new Product("Soup", new Price (79,90)));
        NewResult.addProduct(18505, new Product("Towel", new Price (249,90)));


        assertEquals(OldResult, NewResult);
        assertTrue(OldResult.changePrice(18501, new Price (49,90)));
        assertFalse(OldResult.changePrice(18503, new Price (49,90)));
        assertNotEquals(OldResult, NewResult);
    }

    @Test
    public void changeName(){
        PriceCurrent OldResult = new PriceCurrent();
        PriceCurrent NewResult = new PriceCurrent();

        OldResult.addProduct(18501, new Product("Candle", new Price (99,99)));
        OldResult.addProduct(18504, new Product("Soup", new Price (79,90)));
        OldResult.addProduct(18505, new Product("Towel", new Price (249,90)));
        NewResult.addProduct(18501, new Product("Candle", new Price (99,99)));
        NewResult.addProduct(18504, new Product("Soup", new Price (79,90)));
        NewResult.addProduct(18505, new Product("Towel", new Price (249,90)));

        assertEquals(OldResult, NewResult);
        assertTrue(OldResult.changeName(18501, "Rope"));
        assertFalse(OldResult.changeName(18503, "Spoon"));
        assertNotEquals(OldResult, NewResult);

    }

    @Test
    public void removeProduct(){
        PriceCurrent OldResult = new PriceCurrent();
        PriceCurrent NewResult = new PriceCurrent();

        OldResult.addProduct(18501, new Product("Candle", new Price (99,99)));
        OldResult.addProduct(18504, new Product("Soup", new Price (79,90)));
        OldResult.addProduct(18505, new Product("Towel", new Price (249,90)));
        NewResult.addProduct(18501, new Product("Candle", new Price (99,99)));
        NewResult.addProduct(18504, new Product("Soup", new Price (79,90)));
        NewResult.addProduct(18505, new Product("Towel", new Price (249,90)));

        assertEquals(OldResult, NewResult);
        assertTrue(OldResult.removeProduct(18501));
        assertFalse(OldResult.removeProduct(18503));
        assertNotEquals(OldResult, NewResult);
    }

    @Test
    public void finalCost(){
        PriceCurrent OldResult = new PriceCurrent();
        PriceCurrent NewResult = new PriceCurrent();

        OldResult.addProduct(18501, new Product("Candle", new Price (99,99)));
        OldResult.addProduct(18504, new Product("Soup", new Price (79,90)));
        OldResult.addProduct(18505, new Product("Towel", new Price (249,90)));
        NewResult.addProduct(18501, new Product("Candle", new Price (99,99)));
        NewResult.addProduct(18504, new Product("Soup", new Price (79,90)));
        NewResult.addProduct(18505, new Product("Towel", new Price (249,90)));

        assertEquals(OldResult, NewResult);
        assertTrue(OldResult.changeName(18501, "Rope"));
        assertFalse(OldResult.changeName(18503, "Spoon"));
        assertNotEquals(OldResult, NewResult);

        assertEquals(new Price (299,97), NewResult.finalCost(18501, 3));
        assertNotEquals(new Price (299,97), NewResult.finalCost(18504, 3));
    }
}
