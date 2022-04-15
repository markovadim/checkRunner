package by.markov.dao;

import by.markov.models.entity.Product;
import by.markov.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;

public class ProductDAO {

    public Product getProduct(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Product product = session.get(Product.class, id);
        System.out.println(product);
        session.close();
        return product;
    }
}
