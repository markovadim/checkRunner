package by.markov.services.exceptions;

public class IdNotFoundException extends Exception {
    private int id;

    public int getId() {
        return id;
    }

    public IdNotFoundException(String message, int id) {
        super(message);
        this.id = id;
    }
}
