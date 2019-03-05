package com.lxisoft.ekart.service.impl;

import com.lxisoft.ekart.service.SellerService;
import com.lxisoft.ekart.service.dto.SellerDTO;
import com.lxisoft.ekart.service.mapper.SellerMapper;
import com.lxisoft.ekart.domain.Seller;
import com.lxisoft.ekart.repository.SellerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Service Implementation for managing Seller.
 */
@Service
@Transactional
public class SellerServiceImpl implements SellerService {

    private final Logger log = LoggerFactory.getLogger(SellerServiceImpl.class);

    private final SellerRepository sellerRepository;

    private final SellerMapper sellerMapper;

    public SellerServiceImpl(SellerRepository sellerRepository , SellerMapper sellerMapper) {
        this.sellerRepository = sellerRepository;
        this.sellerMapper = sellerMapper;
    }

    /**
     * Save a seller.
     *
     * @param seller the entity to save
     * @return the persisted entity
     */
    @Override
    public Seller save(Seller seller) {
        log.debug("Request to save Seller : {}", seller);
        return sellerRepository.save(seller);
    }

    /**
     * Get all the sellers.
     *
     * @return the list of entities
     */

     @Override
    @Transactional(readOnly = true)
    public List<SellerDTO> findAll() {
        log.debug("Request to get all Sellers");
        return sellerRepository.findAll().stream()
        .map(sellerMapper::toDto)
        .collect(Collectors.toList());
    }


    /**
     * Get one seller by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<SellerDTO> findOne(Long id) {
        log.debug("Request to get Seller : {}", id);
        return sellerRepository.findById(id)
        .map(sellerMapper::toDto);
    }

    /**
     * Delete the seller by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Seller : {}", id);        sellerRepository.deleteById(id);
    }
}
