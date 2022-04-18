package by.markov.models;

import by.markov.models.entity.Product;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ShopBasketTest {

    ArrayList<Product> products = Mockito.mock(ArrayList.class);
    ArrayList<Integer> amount = Mockito.mock(ArrayList.class);

    ShopBasket shopBasket;

//    @Before
//    public void initBasket() {
//        shopBasket = new ShopBasket(products, amount);
//        Mockito.when(products.get(1)).thenReturn(Products.WATER);
//        Mockito.when(amount.set(1, 3)).thenReturn(true);
//    }

//    @Test
//    public void getProducts() {
//        assertEquals(shopBasket.getProductsFromDataBase().get(1).getProduct(), "Water");
//        assertEquals(shopBasket.getAmount(), amount);
//    }
}