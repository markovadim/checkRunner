package by.markov.services.cashiers;

import by.markov.services.exceptions.CashierHandlerException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class CashierCreatorTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void whenCreateNewCashierWithExistingNameThenReturnCashier() throws CashierHandlerException {
        CashierCreator cashierCreator = new CashierCreator();
        String cashierName = "CASHIER";
        assertEquals(cashierCreator.create(cashierName).getName(),cashierName);
    }

    @Test
    public void whenCreateNewCashierWithoutExistingNameThenThrowCashierHandlerException() throws CashierHandlerException {
        thrown.expect(CashierHandlerException.class);
        thrown.expectMessage("Is not available cashier.");
        CashierCreator cashierCreator = new CashierCreator();
        String cashierName = "Wrong Name";
        cashierCreator.create(cashierName);
    }
}