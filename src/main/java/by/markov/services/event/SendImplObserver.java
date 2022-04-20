package by.markov.services.event;

import by.markov.models.Products;
import by.markov.services.mailsender.Sender;

import javax.mail.MessagingException;
import java.io.IOException;

public class SendImplObserver implements Observer {

    @Override
    public void handleEvent(Products product, double newPrice) throws MessagingException, IOException {
        String message = "Dear friend! Product " + product.getProduct() + " has new price: $" + newPrice;
        new Sender().sendCheckToMail(message);
    }
}
