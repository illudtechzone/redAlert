package com.lxisoft.ekart.service;

import com.lxisoft.ekart.domain.Category;
import com.lxisoft.ekart.service.dto.CategoryDTO;
import com.lxisoft.ekart.service.dto.CategoryListDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing Category.
 */
public interface CategoryService {

    /**
     * Save a category.
     *
     * @param categoryDTO the entity to save
     * @return the persisted entity
     */
    Category save(Category category);

    /**
     * Get all the categories.
     *
     * @return the list of entities
     */
    List<CategoryDTO> findAll();

    List<CategoryListDTO> findAllCategoryName();


    /**
     * Get the "id" category.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<CategoryDTO> findOne(Long id);

    /**
     * Delete the "id" category.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
