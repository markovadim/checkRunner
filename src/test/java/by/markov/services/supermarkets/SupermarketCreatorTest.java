package by.markov.services.supermarkets;

import by.markov.models.Supermarket;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class SupermarketCreatorTest {

    Supermarket supermarketMock = Mockito.mock(Supermarket.class);

    SupermarketCreator supermarketCreator;

    @Before
    public void init() {
        supermarketCreator = new SupermarketCreator();
        when(supermarketMock.getName()).thenReturn("SUPERMARKET 123");
    }

    @Test
    public void createMarket() {
        assertEquals(supermarketCreator.createDefaultSupermarket().getName(), supermarketMock.getName());
    }
}