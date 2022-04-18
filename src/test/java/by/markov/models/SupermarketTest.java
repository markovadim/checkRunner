package by.markov.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class SupermarketTest {

    Supermarket supermarket;

    @Test
    public void supermarketToString() {
        supermarket = new Supermarket("Market", "Minsk", "911");
        assertEquals(supermarket.toString(), String.format("%25s%n%29s%n%25s%n", "Market", "Minsk", "911"));
    }

}