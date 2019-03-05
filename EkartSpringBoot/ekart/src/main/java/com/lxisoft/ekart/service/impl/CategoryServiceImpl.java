package com.lxisoft.ekart.service.impl;

import com.lxisoft.ekart.service.CategoryService;
import com.lxisoft.ekart.domain.Category;
import com.lxisoft.ekart.repository.CategoryRepository;
import com.lxisoft.ekart.service.dto.CategoryDTO;
import com.lxisoft.ekart.service.dto.CategoryListDTO;
import com.lxisoft.ekart.service.mapper.CategoryListMapper;
import com.lxisoft.ekart.service.mapper.CategoryMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing Category.
 */
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private final Logger log = LoggerFactory.getLogger(CategoryServiceImpl.class);

    private final CategoryRepository categoryRepository;

    private final CategoryMapper categoryMapper;

    private final CategoryListMapper categoryListMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper , CategoryListMapper categoryListMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
        this.categoryListMapper = categoryListMapper;
    }

    /**
     * Save a category.
     *
     * @param categoryDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public Category save(Category category) {
        log.debug("Request to save Category : {}", category);
        category = categoryRepository.save(category);
        return category;
    }

    /**
     * Get all the categories.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<CategoryDTO> findAll() {
        log.debug("Request to get all Categories");
        
        return categoryRepository.findAll().stream()
            .map(categoryMapper::toDto)
            .collect(Collectors.toList());
    }

    public List<CategoryListDTO> findAllCategoryName() {

        log.debug("Request to get all Categories");
        
        return categoryRepository.findAll().stream()
            .map(categoryListMapper::toDto)
            .collect(Collectors.toList());
    }


    /**
     * Get one category by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<CategoryDTO> findOne(Long id) {
        log.debug("Request to get Category : {}", id);
        return categoryRepository.findById(id)
            .map(categoryMapper::toDto);
    }

    /**
     * Delete the category by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Category : {}", id);        categoryRepository.deleteById(id);
    }
}
