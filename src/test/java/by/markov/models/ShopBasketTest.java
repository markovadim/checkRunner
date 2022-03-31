package by.markov.models;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ShopBasketTest {

    ArrayList products = Mockito.mock(ArrayList.class);
    ArrayList amount = Mockito.mock(ArrayList.class);

    ShopBasket shopBasket;

    @Before
    public void initBasket() {
        shopBasket = new ShopBasket(products, amount);
        Mockito.when(products.get(1)).thenReturn(Products.WATER);
        Mockito.when(amount.set(1, 3)).thenReturn(true);
    }

    @Test
    public void getProducts() {
        assertEquals(shopBasket.getProducts().get(1).getProduct(), "Water");
        assertEquals(shopBasket.getAmount(), amount);
    }
}