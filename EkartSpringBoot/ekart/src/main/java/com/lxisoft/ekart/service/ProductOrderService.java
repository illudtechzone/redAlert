package com.lxisoft.ekart.service;

import com.lxisoft.ekart.domain.ProductOrder;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing ProductOrder.
 */
public interface ProductOrderService {

    /**
     * Save a productOrder.
     *
     * @param productOrder the entity to save
     * @return the persisted entity
     */
    ProductOrder save(ProductOrder productOrder);

    /**
     * Get all the productOrders.
     *
     * @return the list of entities
     */
    List<ProductOrder> findAll();


    /**
     * Get the "id" productOrder.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<ProductOrder> findOne(Long id);

    /**
     * Delete the "id" productOrder.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
