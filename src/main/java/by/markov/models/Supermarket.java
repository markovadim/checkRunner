package by.markov.models;

public class Supermarket {
    private String name;
    private String address;
    private String phone;


    public Supermarket(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return String.format("%25s%n%29s%n%25s%n",name,address,phone);
    }
}
