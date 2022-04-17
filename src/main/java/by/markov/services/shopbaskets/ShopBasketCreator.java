package by.markov.services.shopbaskets;

import by.markov.models.Card;
import by.markov.models.ShopBasket;
import by.markov.models.entity.Product;
import by.markov.services.database.ProductService;
import by.markov.services.payments.PaymentHandler;
import org.apache.log4j.Logger;

import java.util.ArrayList;

public class ShopBasketCreator {
    static final Logger logger = Logger.getLogger(ShopBasketCreator.class);

    public ShopBasket createShopBasket(ArrayList<Integer> positionIds, ArrayList<Integer> amount, Card card) throws Exception {
        ProductService productService = new ProductService();

        //get products from database
        ArrayList<Product> productList = productService.getProduct(positionIds);
        ShopBasket shopBasket = new ShopBasket(productList, amount);
        logger.info("Created the object of shop basket.");

        PaymentHandler payment = new PaymentHandler();
        payment.pay(shopBasket, card);
        return shopBasket;
    }
}
