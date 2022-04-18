package by.markov.models;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class ProductsTest {

    Map<Integer, Products> products;

    @Before
    public void putProducts() {
        products = new HashMap<>();
        products.put(1, Products.WATER);
        products.put(14, Products.TOMATO);
    }

    @Test
    public void getIdProduct() {
        assertEquals(Products.WATER.getId(), 1);
    }

    @Test
    public void checkPriceNotNull() {
        assertNotEquals(Products.WATER.getPrice(), 0.0);
    }

    @Test
    public void getProductName() {
        assertTrue(products.containsValue(Products.TOMATO));
        assertEquals(products.get(1).toString(), "Water");
        assertEquals(Products.WATER.getProduct(), "Water");
    }

    @Test
    public void checkDiscount() {
        assertTrue(Products.TOMATO.isDiscount());
    }
}