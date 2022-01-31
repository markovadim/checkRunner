package by.markov.services.supermarkets;

import by.markov.models.Supermarket;

public class SupermarketCreator {
    public final static String DEFAULT_SUPERMARKET_NAME = "SUPERMARKET 123";
    public final static String DEFAULT_SUPERMARKET_ADDRESS = "12, MILKYWAY Galaxy/Earth";
    public final static String DEFAULT_SUPERMARKET_PHONE = "Tel :123-456-7890";

    public Supermarket createDefaultSupermarket() {
        Supermarket supermarket = new Supermarket(DEFAULT_SUPERMARKET_NAME, DEFAULT_SUPERMARKET_ADDRESS, DEFAULT_SUPERMARKET_PHONE);
        return supermarket;
    }
}
