package com.lxisoft.ekart.web.rest;
import com.lxisoft.ekart.domain.Seller;
import com.lxisoft.ekart.service.SellerService;
import com.lxisoft.ekart.service.dto.SellerDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

/**
 * REST controller for managing Seller.
 */
@RestController
@RequestMapping("/api")
public class SellerResource {

    private final Logger log = LoggerFactory.getLogger(SellerResource.class);

    private static final String ENTITY_NAME = "ekartSeller";

    private final SellerService sellerService;

    public SellerResource(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    /**
     * POST  /sellers : Create a new seller.
     *
     * @param seller the seller to create
     * @return the ResponseEntity with status 201 (Created) and with body the new seller, or with status 400 (Bad Request) if the seller has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/sellers")
    public ResponseEntity<Seller> createSeller(@RequestBody Seller seller) throws URISyntaxException {
        log.debug("REST request to save Seller : {}", seller);
        Seller result = sellerService.save(seller);
        return ResponseEntity.created(new URI("/api/sellers/" + result.getId()))
            .body(result);
    }

    /**
     * PUT  /sellers : Updates an existing seller.
     *
     * @param seller the seller to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated seller,
     * or with status 400 (Bad Request) if the seller is not valid,
     * or with status 500 (Internal Server Error) if the seller couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/sellers")
    public ResponseEntity<Seller> updateSeller(@RequestBody Seller seller) throws URISyntaxException {
        log.debug("REST request to update Seller : {}", seller);
        Seller result = sellerService.save(seller);
        return ResponseEntity.ok()
            .body(result);
    }

    /**
     * GET  /sellers : get all the sellers.
     *
     * @param filter the filter of the request
     * @return the ResponseEntity with status 200 (OK) and the list of sellers in body
     */
    @GetMapping("/sellers")
    public List<SellerDTO> getAllSellers(@RequestParam(required = false) String filter) {
        log.debug("REST request to get all Sellers");
        return sellerService.findAll();
    }

    /**
     * GET  /sellers/:id : get the "id" seller.
     *
     * @param id the id of the seller to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the seller, or with status 404 (Not Found)
     */
    @GetMapping("/sellers/{id}")
    public ResponseEntity<SellerDTO> getSeller(@PathVariable Long id) {
        log.debug("REST request to get Seller : {}", id);
        Optional<SellerDTO> seller = sellerService.findOne(id);
        return ResponseEntity.ok().body(seller.get());
    }

    /**
     * DELETE  /sellers/:id : delete the "id" seller.
     *
     * @param id the id of the seller to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/sellers/{id}")
    public ResponseEntity<Void> deleteSeller(@PathVariable Long id) {
        log.debug("REST request to delete Seller : {}", id);
        sellerService.delete(id);
        return ResponseEntity.ok().body(null);
    }
}
