package com.illud.redalert.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.illud.redalert.domain.UserExtra;

import java.util.Optional;

/**
 * Service Interface for managing UserExtra.
 */
public interface UserExtraService {

    /**
     * Save a userExtra.
     *
     * @param userExtra the entity to save
     * @return the persisted entity
     */
    UserExtra save(UserExtra userExtra);

    /**
     * Get all the userExtras.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<UserExtra> findAll(Pageable pageable);

    /**
     * Get all the UserExtra with eager load of many-to-many relationships.
     *
     * @return the list of entities
     */
    Page<UserExtra> findAllWithEagerRelationships(Pageable pageable);
    
    /**
     * Get the "id" userExtra.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<UserExtra> findOne(String userEmail);

    /**
     * Delete the "id" userExtra.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
