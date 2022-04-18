package by.markov.services.payments;

import by.markov.models.Card;
import by.markov.models.Receipt;
import by.markov.models.ShopBasket;
import by.markov.services.receipts.ReceiptsHandler;

import org.apache.log4j.Logger;

public class PaymentHandler {
    private Receipt receipt;
    private ReceiptsHandler handler;
    private static final double DISCOUNT_KF = 0.1;
    private static final double SUM_WITH_DISCOUNT = 0.9;
    private static final int MIN_PRODUCTS_BORDER = 5;

    static final Logger logger = Logger.getLogger(PaymentHandler.class);

    public void pay(ShopBasket shopBasket, Card card) throws Exception {
        logger.info("The payment...");
        double sumToPayment = 0, discount = 0, taxable = 0, currentSumOfProduct;

        for (int i = 0; i < shopBasket.getAmount().size(); i++) {
            currentSumOfProduct = shopBasket.getAmount().get(i) * shopBasket.getProductsFromDataBase().get(i).getPrice();
            taxable += currentSumOfProduct;
            if ((shopBasket.getAmount().get(i) >= MIN_PRODUCTS_BORDER) && (shopBasket.getProductsFromDataBase().get(i).isDiscount())) {
                discount += DISCOUNT_KF * shopBasket.getAmount().get(i) * shopBasket.getProductsFromDataBase().get(i).getPrice();
                sumToPayment += SUM_WITH_DISCOUNT * shopBasket.getAmount().get(i) * shopBasket.getProductsFromDataBase().get(i).getPrice();
            } else {
                sumToPayment += currentSumOfProduct;
            }
        }
        logger.info("Calculated the amount of the discount and the amount of payment");

        receipt = new Receipt(shopBasket, taxable, discount, card, sumToPayment);
        logger.info("Created the receipt");

        handler = new ReceiptsHandler();
        handler.getReceipt(receipt);
        logger.info("The receipt was recorded in the txt file");
    }
}
