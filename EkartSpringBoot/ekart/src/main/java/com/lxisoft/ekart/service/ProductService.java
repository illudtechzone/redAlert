package com.lxisoft.ekart.service;

import com.lxisoft.ekart.domain.Product;
import com.lxisoft.ekart.service.dto.ProductDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing Product.
 */
public interface ProductService {

    /**
     * Save a product.
     *
     * @param productDTO the entity to save
     * @return the persisted entity
     */
    Product save(Product product);

    /**
     * Get all the products.
     *
     * @return the list of entities
     */
    List<ProductDTO> findAll();

    /**
     * Get all the Product with eager load of many-to-many relationships.
     *
     * @return the list of entities
     */
    Page<ProductDTO> findAllWithEagerRelationships(Pageable pageable);
    
    /**
     * Get the "id" product.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<ProductDTO> findOne(Long id);

    /**
     * Delete the "id" product.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
