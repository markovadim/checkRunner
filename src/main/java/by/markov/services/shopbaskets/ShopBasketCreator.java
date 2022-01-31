package by.markov.services.shopbaskets;

import by.markov.models.Card;
import by.markov.models.Products;
import by.markov.models.ShopBasket;
import by.markov.services.exceptions.IdNotFoundException;
import by.markov.services.payments.PaymentHandler;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Set;

public class ShopBasketCreator {
    static final Logger logger = Logger.getLogger(ShopBasketCreator.class);

    public ShopBasket createShopBasket(ArrayList<Integer> positionIds, ArrayList<Integer> amount, Card card) throws Exception {
        ShopBasket shopBasket;
        ArrayList<Products> productsInShopBasket = new ArrayList<>();

        for (int position : positionIds) {
            boolean notProduct = true;

            for (int i = 0; i < Products.values().length; i++) {
                if (Products.values()[i].getId() == position) {
                    productsInShopBasket.add(Products.values()[i]);
                    notProduct = false;
                    logger.info("Product <" + Products.values()[i] + "> was put in the basket");
                }
            }
            if (notProduct) {
                throw new IdNotFoundException("Product with id:" + position + " not found", position);
            }
        }

        shopBasket = new ShopBasket(productsInShopBasket, amount);
        logger.info("Created the object of shop basket.");

        PaymentHandler payment = new PaymentHandler();
        payment.pay(shopBasket, amount, card);
        return shopBasket;
    }
}
