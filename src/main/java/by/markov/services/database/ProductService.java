package by.markov.services.database;

import by.markov.dao.ProductDAO;
import by.markov.models.entity.Product;

import java.util.ArrayList;

public class ProductService {

    private final ProductDAO productDAO = new ProductDAO();

    public ArrayList<Product> getProduct(ArrayList<Integer> ids) {
        return productDAO.getProduct(ids);
    }
}
