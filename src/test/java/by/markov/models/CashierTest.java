package by.markov.models;

import by.markov.services.cashiers.CashierCreator;
import by.markov.services.exceptions.CashierHandlerException;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class CashierTest {

    Cashier cashier = Mockito.mock(Cashier.class);

    @Test
    public void getCashier() {
        Cashier defaultCashier = new Cashier(133, "CASHIER");
        assertEquals(defaultCashier.getName(), CashierCreator.DEFAULT_CASHIER_NAME);
        assertEquals(defaultCashier.getIdNumber(), CashierCreator.DEFAULT_ID_NUMBER);
    }

    @Test
    public void getNotCashier() throws CashierHandlerException {
        CashierCreator cashierCreator = new CashierCreator();
        Mockito.when(cashier.getName()).thenReturn("Valentin");
        assertThrows(CashierHandlerException.class, () -> cashierCreator.create(cashier.getName()));
    }
}