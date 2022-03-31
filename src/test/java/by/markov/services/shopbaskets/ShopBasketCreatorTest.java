package by.markov.services.shopbaskets;

import by.markov.models.Products;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class ShopBasketCreatorTest {

    Map<Integer, Products> shopTable;
    ArrayList<Products> products;

    @Before
    public void initLists() {
        shopTable = new HashMap<>();
        products = new ArrayList<>();
        for (Products product : Products.values()) {
            shopTable.put(product.getId(), product);
        }
    }

    @Test
    public void setShopBasketWithIncorrectIdProduct() {
        assertNull(shopTable.get(15));
    }

}