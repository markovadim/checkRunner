package by.markov.services.event;

import by.markov.models.Receipt;

import javax.mail.MessagingException;
import java.io.IOException;

public interface Observable {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers() throws MessagingException, IOException;
}
