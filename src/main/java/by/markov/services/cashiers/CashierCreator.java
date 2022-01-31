package by.markov.services.cashiers;

import by.markov.models.Cashier;
import by.markov.services.exceptions.CashierHandlerException;
import org.apache.log4j.Logger;

import java.util.Set;

public class CashierCreator {
    public final static int DEFAULT_ID_NUMBER = 133;
    public final static String DEFAULT_CASHIER_NAME = "CASHIER";

    private static final Set<String> AVAILABLE_CASHIERS = Set.of(
            DEFAULT_CASHIER_NAME, "Ivan", "Peter", "Oleg"
    );

    static final Logger logger = Logger.getLogger(CashierCreator.class);

    public Cashier create(String cashierName) throws CashierHandlerException {
        Cashier cashier = new Cashier(DEFAULT_ID_NUMBER, cashierName);
        if (!AVAILABLE_CASHIERS.contains(cashier.getName())) {
            logger.info("Cashier with name " + cashier.getName() + " not found");
            throw new CashierHandlerException("Is not available cashier.");
        }
        return cashier;
    }
}
