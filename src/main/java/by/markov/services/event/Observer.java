package by.markov.services.event;

import by.markov.models.Products;

import javax.mail.MessagingException;
import java.io.IOException;

public interface Observer {
    void handleEvent(Products product, double sum) throws MessagingException, IOException;
}
