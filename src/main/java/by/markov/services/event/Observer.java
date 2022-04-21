package by.markov.services.event;

import javax.mail.MessagingException;
import java.io.IOException;

public interface Observer {
    void handleEvent(String message) throws MessagingException, IOException;
}
