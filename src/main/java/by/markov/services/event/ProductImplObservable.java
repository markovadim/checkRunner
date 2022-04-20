package by.markov.services.event;

import by.markov.models.Products;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductImplObservable implements Observable {

    private int id;
    private double newPrice;
    private Products prod;

    List<Observer> subscribes = new ArrayList<>();

    public void changePriceOfProduct(int id, double newPrice) throws MessagingException, IOException {
        for (Products product : Products.values()) {
            if (product.getId() == id) {
                prod = product;
                this.id = id;
                this.newPrice = newPrice;
            }
        }
        notifyObservers();
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
            observer.handleEvent(prod, newPrice);
        }
    }
}
