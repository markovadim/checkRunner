package by.markov.models;

public enum Products {
    WATER(1, "Water", 10.0, true),
    BROAD(2, "Broad", 13.0, false),
    BUTTER(3, "Butter", 11.0, false),
    SUGAR(4, "Sugar", 9.5, false),
    MEAT(5, "Meat", 17.3, false),
    BANANA(6, "Banana", 6.6, true),
    MILK(7, "Milk", 5.8, false),
    SALT(8, "Salt", 3.9, true),
    CHEESE(9, "Cheese", 6.2, true),
    EGGS(10, "Eggs", 4.4, false),
    FISH(11, "Fish", 14.1, false),
    POTATO(12, "Potato", 3.0, true),
    ONION(13, "Onion", 2.5, false),
    TOMATO(14, "Tomato", 3.5, true);


    private int id;
    private String product;
    private double price;
    private boolean isDiscount;

    public int getId() {
        return id;
    }

    public String getProduct() {
        return product;
    }

    public double getPrice() {
        return price;
    }

    public boolean isDiscount() {
        return isDiscount;
    }

    Products(int id, String product, double price, boolean isDiscount) {
        this.id = id;
        this.product = product;
        this.price = price;
        this.isDiscount = isDiscount;
    }

    @Override
    public String toString() {
        return product;
    }
}
