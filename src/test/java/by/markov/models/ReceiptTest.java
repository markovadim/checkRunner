package by.markov.models;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class ReceiptTest {

    ShopBasket shopBasketMock = Mockito.mock(ShopBasket.class);
    Card cardMock = Mockito.mock(Card.class);

    Receipt receipt;

    @Before
    public void initReceipt() {
        receipt = new Receipt(shopBasketMock, 100.0, 10.0, cardMock, 90.0);
    }

    @Test
    public void checkSumOfPay() {
        assertNotEquals(receipt.getSum(), 100.0);
    }

    @Test
    public void getTitleAndShopBasketOfReceipt() {
        assertEquals(Receipt.TITLE, "CASH RECEIPT");
        assertEquals(receipt.getDiscount(), 10.0, 0.0);
        assertEquals(receipt.getTaxable(), 100.0, 0.0);
        assertEquals(receipt.getShopBasket(), shopBasketMock);
    }
}