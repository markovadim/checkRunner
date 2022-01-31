package by.markov.services.payments;

import by.markov.models.Card;
import by.markov.models.Receipt;
import by.markov.models.ShopBasket;
import by.markov.services.cashiers.CashierCreator;
import by.markov.services.receipts.ReceiptsHandler;

import java.util.ArrayList;

import org.apache.log4j.Logger;

public class PaymentHandler {
    private Receipt receipt;

    public Receipt getReceipt() {
        return receipt;
    }

    static final Logger logger = Logger.getLogger(PaymentHandler.class);

    public void pay(ShopBasket shopBasket, ArrayList<Integer> amount, Card card) throws Exception {
        logger.info("The payment.");
        double sumToPayment = 0, discount = 0, taxable = 0;

        CashierCreator cashierCreator = new CashierCreator();
        cashierCreator.create(CashierCreator.DEFAULT_CASHIER_NAME);
        logger.info("The cashier with id: " + CashierCreator.DEFAULT_ID_NUMBER + " and name: " + CashierCreator.DEFAULT_CASHIER_NAME + " was created");

        for (int i = 0; i < shopBasket.getProducts().size(); i++) {
            taxable += amount.get(i) * shopBasket.getProducts().get(i).getPrice();
            if ((amount.get(i) >= 5) && (shopBasket.getProducts().get(i).isDiscount())) {
                sumToPayment += amount.get(i) * shopBasket.getProducts().get(i).getPrice() * 0.9;
                discount += amount.get(i) * shopBasket.getProducts().get(i).getPrice() * 0.1;
            } else {
                sumToPayment += amount.get(i) * shopBasket.getProducts().get(i).getPrice();
            }
        }
        logger.info("Calculated the amount of the discount and the amount of payment");

        receipt = new Receipt(shopBasket, taxable, discount, card, sumToPayment);
        logger.info("Created the receipt");

        ReceiptsHandler handler = new ReceiptsHandler();
        handler.getReceipt(receipt);
        logger.info("The receipt was recorded in the txt file");
    }
}
