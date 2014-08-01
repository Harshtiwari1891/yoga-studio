package com.app.studio.dao;

import com.app.studio.model.Product;

/**
 *
 * @author aTabibi
 */
public interface ProductDAO {

    /**
     * Create a new product
     *
     * @param p
     * @return
     */
    public Product create(Product p);

    /**
     * Update existing product
     *
     * @param p
     * @return
     */
    public Product update(Product p);

    /**
     * Get product by ID
     *
     * @param id
     * @return
     */
    public Product getById(int id);

    /**
     * Remove product
     *
     * @param id
     * @return
     */
    public Product remove(int id);

}
