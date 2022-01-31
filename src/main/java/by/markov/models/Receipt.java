package by.markov.models;

public class Receipt {
    private ShopBasket shopBasket;
    private double discount;
    private double sum;
    private Card card;
    private double taxable;
    public final static String TITLE = "CASH RECEIPT";

    public ShopBasket getShopBasket() {
        return shopBasket;
    }

    public double getSum() {
        return sum;
    }

    public double getDiscount() {
        return discount;
    }

    public double getTaxable() {
        return taxable;
    }

    public Receipt(ShopBasket shopBasket, double taxable, double discount, Card card, double sum) {
        this.shopBasket = shopBasket;
        this.taxable = taxable;
        this.discount = discount;
        this.card = card;
        this.sum = sum;
    }
}
