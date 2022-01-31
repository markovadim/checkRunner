package by.markov.models;

import java.util.ArrayList;

public class ShopBasket {
    private ArrayList<Products> products;
    private ArrayList<Integer> amount;

    public ArrayList<Products> getProducts() {
        return products;
    }

    public ArrayList<Integer> getAmount() {
        return amount;
    }

    public ShopBasket(ArrayList<Products> products, ArrayList<Integer> amount) {
        this.products = products;
        this.amount = amount;
    }
}
