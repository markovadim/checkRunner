package by.markov.models;

import by.markov.services.event.Observable;
import by.markov.services.event.Observer;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Receipt implements Observable {
    private ShopBasket shopBasket;
    private double discount;
    private double sum;
    private Card card;
    private double taxable;
    public final static String TITLE = "CASH RECEIPT";

    private List<Observer> subscribes = new ArrayList<>();

    public ShopBasket getShopBasket() {
        return shopBasket;
    }

    public double getSum() {
        return sum;
    }

    public double getDiscount() {
        return discount;
    }

    public double getTaxable() {
        return taxable;
    }

    public Receipt(ShopBasket shopBasket, double taxable, double discount, Card card, double sum) {
        this.shopBasket = shopBasket;
        this.taxable = taxable;
        this.discount = discount;
        this.card = card;
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Receipt:" +
                "shopBasket:" + shopBasket +
                ", discount:" + discount +
                ", sum:" + sum +
                ", card:" + card +
                ", taxable:" + taxable;
    }

    @Override
    public void addObserver(Observer observer) {
        subscribes.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        subscribes.remove(observer);
    }

    @Override
    public void notifyObservers() throws MessagingException, IOException {
        for (Observer observer:subscribes){
            observer.handleEvent(toString());
        }
    }
}
