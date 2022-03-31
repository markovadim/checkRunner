package by.markov.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CardTest {
    Card card, card2;

    @Before
    public void initCard() {
        card = new Card(1331);
        card2 = new Card();
    }

    @Test
    public void getCardWithNumber() {
        assertEquals(card.getNumber(), 1331);
    }

    @Test
    public void getCardWithoutNumber() {
        assertEquals(card2.getNumber(), 0);
    }
}
