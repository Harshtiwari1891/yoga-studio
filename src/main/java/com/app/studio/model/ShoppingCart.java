package com.app.studio.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity which is going to hold the Shopping cart data
 *
 * @author malalanayake
 */
@Entity
@Table(name = "SHOPPING_CART")
public class ShoppingCart {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.EAGER)
    private Customer customer;
    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private Set<Product> setOfProducts;

    public ShoppingCart() {
        this.setOfProducts = new HashSet<Product>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<Product> getSetOfProducts() {
        return setOfProducts;
    }

    public void addProduct(Product product) {
        this.setOfProducts.add(product);
    }

    @Override
    public String toString() {
        return "ShoppingCart{" + "id=" + id + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + this.id;
        hash = 19 * hash + (this.customer != null ? this.customer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ShoppingCart other = (ShoppingCart) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.customer != other.customer && (this.customer == null || !this.customer.equals(other.customer))) {
            return false;
        }
        return true;
    }

}
