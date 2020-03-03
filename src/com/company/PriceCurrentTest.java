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

        assertEquals(result.getProductByCode(18500), new Product("Book", new Price(549, 99)));
        assertEquals(result.getProductByCode(18501), new Product("Candle", new Price (99,99)));

        assertEquals(new Price (99,99), result.finalCost(18501, 1));
        assertNotEquals(new Price (299,97), result.finalCost(18504, 1));


    }

    @Test
    public void changePrice(){
        PriceCurrent oldResult = new PriceCurrent();
        PriceCurrent newResult = new PriceCurrent();

        oldResult.addProduct(18501, new Product("Candle", new Price (99,99)));
        oldResult.addProduct(18504, new Product("Soup", new Price (79,90)));
        oldResult.addProduct(18505, new Product("Towel", new Price (249,90)));
        newResult.addProduct(18501, new Product("Candle", new Price (99,99)));
        newResult.addProduct(18504, new Product("Soup", new Price (79,90)));
        newResult.addProduct(18505, new Product("Towel", new Price (249,90)));


        assertEquals(oldResult, newResult);
        assertTrue(oldResult.changePrice(18501, new Price (49,90)));
        assertFalse(oldResult.changePrice(18503, new Price (49,90)));
        assertNotEquals(oldResult, newResult);
    }

    @Test
    public void changeName(){
        PriceCurrent oldResult = new PriceCurrent();
        PriceCurrent newResult = new PriceCurrent();

        oldResult.addProduct(18501, new Product("Candle", new Price (99,99)));
        oldResult.addProduct(18504, new Product("Soup", new Price (79,90)));
        oldResult.addProduct(18505, new Product("Towel", new Price (249,90)));
        newResult.addProduct(18501, new Product("Candle", new Price (99,99)));
        newResult.addProduct(18504, new Product("Soup", new Price (79,90)));
        newResult.addProduct(18505, new Product("Towel", new Price (249,90)));

        assertEquals(oldResult, newResult);
        assertTrue(oldResult.changeName(18501, "Rope"));
        assertFalse(oldResult.changeName(18503, "Spoon"));
        assertNotEquals(oldResult, newResult);

    }

    @Test
    public void removeProduct(){
        PriceCurrent oldResult = new PriceCurrent();
        PriceCurrent newResult = new PriceCurrent();

        oldResult.addProduct(18501, new Product("Candle", new Price (99,99)));
        oldResult.addProduct(18504, new Product("Soup", new Price (79,90)));
        oldResult.addProduct(18505, new Product("Towel", new Price (249,90)));
        newResult.addProduct(18501, new Product("Candle", new Price (99,99)));
        newResult.addProduct(18504, new Product("Soup", new Price (79,90)));
        newResult.addProduct(18505, new Product("Towel", new Price (249,90)));

        assertEquals(oldResult, newResult);
        assertTrue(oldResult.removeProduct(18501));
        assertFalse(oldResult.removeProduct(18503));
        assertNotEquals(oldResult, newResult);
    }

    @Test
    public void finalCost(){
        PriceCurrent oldResult = new PriceCurrent();
        PriceCurrent newResult = new PriceCurrent();

        oldResult.addProduct(18501, new Product("Candle", new Price (99,99)));
        oldResult.addProduct(18504, new Product("Soup", new Price (79,90)));
        oldResult.addProduct(18505, new Product("Towel", new Price (249,90)));
        newResult.addProduct(18501, new Product("Candle", new Price (99,99)));
        newResult.addProduct(18504, new Product("Soup", new Price (79,90)));
        newResult.addProduct(18505, new Product("Towel", new Price (249,90)));

        assertEquals(oldResult, newResult);
        assertTrue(oldResult.changeName(18501, "Rope"));
        assertFalse(oldResult.changeName(18503, "Spoon"));
        assertNotEquals(oldResult, newResult);

        assertEquals(new Price (299,97), newResult.finalCost(18501, 3));
        assertNotEquals(new Price (299,97), newResult.finalCost(18504, 3));
    }
}
