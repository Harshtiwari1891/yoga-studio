package com.app.studio.dao.impl;

import com.app.studio.dao.ProductDAO;
import com.app.studio.model.Product;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 *
 * @author aTabibi
 */
@Repository
public class ProductDAOImpl implements ProductDAO {

    private static final Logger logger = LoggerFactory.getLogger(ProductDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public Product create(Product p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
        if (logger.isDebugEnabled()) {
            logger.debug("Product saved successfully, Product Details=" + p);
        }
        return p;
    }

    @Override
    public Product update(Product p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(p);
        if (logger.isDebugEnabled()) {
            logger.debug("Product saved successfully, Product Details=" + p);
        }
        return p;
    }

    @Override
    public List<Product> list() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Product> productList = session.createQuery("from Product").list();
        if (logger.isDebugEnabled()) {
            for (Product product : productList) {
                logger.debug("Product List::" + product);
            }
        }
        return productList;

    }

    @Override
    public Product getById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Product p = (Product) session.get(Product.class, new Integer(id));
        if (logger.isDebugEnabled()) {
            logger.debug("Product loaded successfully, Product Details=" + p);
        }
        return p;
    }

    @Override
    public Product remove(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Product p = (Product) session.load(Product.class, new Integer(id));
        if (null!=p) {
            session.delete(p);
        }
        if (logger.isDebugEnabled()) {
            logger.debug("Product deleted successfully, Product Details=" + p);
        }
        return p;
    }

}
