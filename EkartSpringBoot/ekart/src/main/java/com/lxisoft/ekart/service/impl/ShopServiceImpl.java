package com.lxisoft.ekart.service.impl;

import com.lxisoft.ekart.service.ShopService;
import com.lxisoft.ekart.domain.Shop;
import com.lxisoft.ekart.repository.ShopRepository;
import com.lxisoft.ekart.service.dto.ShopDTO;
import com.lxisoft.ekart.service.mapper.ShopMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing Shop.
 */
@Service
@Transactional
public class ShopServiceImpl implements ShopService {

    private final Logger log = LoggerFactory.getLogger(ShopServiceImpl.class);

    private final ShopRepository shopRepository;

    private final ShopMapper shopMapper;

    public ShopServiceImpl(ShopRepository shopRepository, ShopMapper shopMapper) {
        this.shopRepository = shopRepository;
        this.shopMapper = shopMapper;
    }

    /**
     * Save a shop.
     *
     * @param shopDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public Shop save(Shop shop) {
        log.debug("Request to save Shop : {}", shop);
        shop = shopRepository.save(shop);
        return shop;
    }

    /**
     * Get all the shops.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<ShopDTO> findAll() {
        log.debug("Request to get all Shops");
        return shopRepository.findAll().stream()
            .map(shopMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one shop by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<ShopDTO> findOne(Long id) {
        log.debug("Request to get Shop : {}", id);
        return shopRepository.findById(id)
            .map(shopMapper::toDto);
    }

    /**
     * Delete the shop by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Shop : {}", id);        shopRepository.deleteById(id);
    }
}
