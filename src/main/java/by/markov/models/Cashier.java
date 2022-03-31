package by.markov.models;

public class Cashier {

    private int idNumber;
    private String name;

    public Cashier(int idNumber, String name) {
        this.idNumber = idNumber;
        this.name = name;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public String getName() {
        return name;
    }
}
