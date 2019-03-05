package com.lxisoft.ekart.service;

import com.lxisoft.ekart.service.dto.ShopDTO;
import com.lxisoft.ekart.domain.Shop;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing Shop.
 */
public interface ShopService {

    /**
     * Save a shop.
     *
     * @param shopDTO the entity to save
     * @return the persisted entity
     */
    Shop save(Shop shop);

    /**
     * Get all the shops.
     *
     * @return the list of entities
     */
    List<ShopDTO> findAll();


    /**
     * Get the "id" shop.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<ShopDTO> findOne(Long id);

    /**
     * Delete the "id" shop.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
