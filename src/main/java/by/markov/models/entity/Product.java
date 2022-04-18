package by.markov.models.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String product;

    @Column
    private double price;

    @Column
    private boolean isDiscount;

    public Product() {
    }

    public Product(String product, double price, boolean isDiscount) {
        this.product = product;
        this.price = price;
        this.isDiscount = isDiscount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", product='" + product + '\'' +
                ", price=" + price +
                ", isDiscount=" + isDiscount +
                '}';
    }

    public double getPrice() {
        return price;
    }

    public boolean isDiscount() {
        return isDiscount;
    }

    public String getProduct() {
        return product;
    }
}
