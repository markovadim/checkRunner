package by.markov.models;


public class CashierBuilder {

    private int idNumber;
    private String name;

    public CashierBuilder getId(int idNumber){
        this.idNumber = idNumber;
        return this;
    }

    public CashierBuilder getName(String name){
        this.name = name;
        return this;
    }

    public Cashier build(){
        return new Cashier(idNumber,name);
    }
}
