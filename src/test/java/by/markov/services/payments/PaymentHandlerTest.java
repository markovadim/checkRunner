package by.markov.services.payments;

import by.markov.models.Card;
import by.markov.models.Products;
import by.markov.models.Receipt;
import by.markov.models.ShopBasket;
import by.markov.models.entity.Product;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

public class PaymentHandlerTest {

    ShopBasket shopBasketMock = Mockito.mock(ShopBasket.class);
    Card cardMock = Mockito.mock(Card.class);

    Receipt receipt;
    PaymentHandler paymentHandler;
    ArrayList<Integer> amountOfProducts;
    ArrayList<Product> products;

    @Before
    public void init() throws Exception {
        paymentHandler = new PaymentHandler();
        amountOfProducts = new ArrayList<>();
        products = new ArrayList<>();

        when(shopBasketMock.getProductsFromDataBase()).thenReturn(products);
        when(shopBasketMock.getAmount()).thenReturn(amountOfProducts);
    }


//    @Test
//    public void getSumOfProducts() throws Exception {
//        products.add(Products.WATER);
//        amountOfProducts.add(2);
//        paymentHandler.pay(shopBasketMock, amountOfProducts, cardMock);
//        receipt = paymentHandler.getReceipt();
//        assertEquals(receipt.getSum(), 20.0, 0.0);
//    }

//    @Test
//    public void getSumOfProductsWithDiscountsProducts() throws Exception {
//        products.add(Products.POTATO);
//        amountOfProducts.add(5);
//        paymentHandler.pay(shopBasketMock, amountOfProducts, cardMock);
//        receipt = paymentHandler.getReceipt();
//        assertEquals(receipt.getSum(), 13.5, 0.0);
//    }

    @After
    public void clearList() {
        products.clear();
        amountOfProducts.clear();
    }
}