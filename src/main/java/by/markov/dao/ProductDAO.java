package by.markov.dao;

import by.markov.models.entity.Product;
import by.markov.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;

import java.util.ArrayList;

public class ProductDAO {

    public ArrayList<Product> getProduct(ArrayList<Integer> ids) {
        ArrayList<Product> productList = new ArrayList<>();
        Product product;
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        for (int i = 0; i < ids.size(); i++) {
            product = session.get(Product.class, ids.get(i));
            productList.add(product);
        }
        session.close();
        return productList;
    }
}
