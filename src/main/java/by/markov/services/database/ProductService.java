package by.markov.services.database;

import by.markov.dao.ProductDAO;
import by.markov.models.entity.Product;

public class ProductService {

    ProductDAO productDAO = new ProductDAO();

    public Product getProduct(int id) {
        return productDAO.getProduct(id);
    }
}
