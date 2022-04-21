package by.markov.services.event;

import javax.mail.MessagingException;
import java.io.IOException;

public interface Observable {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers() throws MessagingException, IOException;
}
