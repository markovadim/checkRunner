package by.markov.services.cashiers;

import by.markov.services.exceptions.CashierHandlerException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CashierCreatorTest {

    CashierCreator cashierCreator;

    @Before
    public void init() {
        cashierCreator = new CashierCreator();
    }

    @Test
    public void whenCreateNewCashierWithExistingNameThenReturnCashier() throws CashierHandlerException {
        String cashierName = "CASHIER";
        assertEquals(cashierCreator.createDefaultCashier(cashierName).getName(), cashierName);
    }

    @Test
    public void whenCreateNewCashierWithoutExistingNameThenThrowCashierHandlerException() throws CashierHandlerException {
        String cashierName = "Unknown Name";
        assertThrows(CashierHandlerException.class, () -> cashierCreator.createDefaultCashier(cashierName));
    }
}