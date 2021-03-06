package com.app.studio.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.app.studio.dao.CustomerDAO;
import com.app.studio.model.Customer;

/**
 * DAO class which is providing the customer data access
 *
 * @author malalanayake
 *
 */
@Repository
public class CustomerDAOImpl implements CustomerDAO {

    private static final Logger logger = LoggerFactory.getLogger(CustomerDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public Customer create(Customer p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
        if (logger.isDebugEnabled()) {
            logger.debug("Customer saved successfully, Customer Details=" + p);
        }
        return p;
    }

    @Override
    public Customer update(Customer p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(p);
        if (logger.isDebugEnabled()) {
            logger.debug("Customer updated successfully, Customer Details=" + p);
        }
        return p;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Customer> list() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Customer> customersList = session.createQuery("from Customer").list();
        if (logger.isDebugEnabled()) {
            for (Customer c : customersList) {
                logger.debug("Customer List::" + c);
            }
        }
        return customersList;
    }

    @Override
    public Customer getById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Customer c = (Customer) session.get(Customer.class, new Integer(id));
        if (logger.isDebugEnabled()) {
            logger.debug("Customer loaded successfully, Customer details=" + c);
        }
        return c;
    }

    @Override
    public Customer remove(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Customer c = (Customer) session.load(Customer.class, new Integer(id));
        if (null != c) {
            session.delete(c);
        }
        if (logger.isDebugEnabled()) {
            logger.debug("Customer deleted successfully, Customer details=" + c);
        }
        return c;
    }

    @Override
    public Customer getByUserName(String userName) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Customer> customerList = session.getNamedQuery(Customer.Constants.NAME_QUERY_FIND_BY_USER_NAME)
                .setParameter(Customer.Constants.PARAM_USER_NAME, userName).list();
        Customer customer = null;
        if (!customerList.isEmpty()) {
            customer = customerList.get(0);
        }
        return customer;
    }

}
