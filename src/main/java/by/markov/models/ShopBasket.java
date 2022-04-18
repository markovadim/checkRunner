package by.markov.models;

import by.markov.models.entity.Product;
import lombok.Data;
import java.util.ArrayList;

@Data
public class ShopBasket {
    private ArrayList<Product> productsFromDataBase;
    private ArrayList<Integer> amount;

    public ShopBasket(ArrayList<Product> productsFromDataBase, ArrayList<Integer> amount) {
        this.productsFromDataBase = productsFromDataBase;
        this.amount = amount;
    }
    //without get() lombok don't work (?)
    public ArrayList<Integer> getAmount() {
        return amount;
    }

    public ArrayList<Product> getProductsFromDataBase() {
        return productsFromDataBase;
    }
}
