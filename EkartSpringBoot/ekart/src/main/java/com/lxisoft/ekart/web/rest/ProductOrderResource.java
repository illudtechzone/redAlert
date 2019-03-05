package com.lxisoft.ekart.web.rest;
import com.lxisoft.ekart.domain.ProductOrder;
import com.lxisoft.ekart.service.ProductOrderService;
import com.lxisoft.ekart.service.dto.ProductOrderDTO;
import com.lxisoft.ekart.service.mapper.ProductOrderMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * REST controller for managing ProductOrder.
 */
@RestController
@RequestMapping("/api")
public class ProductOrderResource {

    private final Logger log = LoggerFactory.getLogger(ProductOrderResource.class);

    private static final String ENTITY_NAME = "ekartProductOrder";

    private final ProductOrderService productOrderService;

    private final ProductOrderMapper productOrderMapper;

    public ProductOrderResource(ProductOrderService productOrderService , ProductOrderMapper productOrderMapper) {
        this.productOrderService = productOrderService;
        this.productOrderMapper = productOrderMapper;
    }

    /**
     * POST  /product-orders : Create a new productOrder.
     *
     * @param productOrder the productOrder to create
     * @return the ResponseEntity with status 201 (Created) and with body the new productOrder, or with status 400 (Bad Request) if the productOrder has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/product-orders")
    public ResponseEntity<ProductOrder> createProductOrder(@RequestBody ProductOrder productOrder) throws URISyntaxException {
        log.debug("REST request to save ProductOrder : {}", productOrder);
        ProductOrder result = productOrderService.save(productOrder);
        return ResponseEntity.created(new URI("/api/product-orders/" + result.getId()))
            .body(result);
    }

    /**
     * PUT  /product-orders : Updates an existing productOrder.
     *
     * @param productOrder the productOrder to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated productOrder,
     * or with status 400 (Bad Request) if the productOrder is not valid,
     * or with status 500 (Internal Server Error) if the productOrder couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/product-orders")
    public ResponseEntity<ProductOrder> updateProductOrder(@RequestBody ProductOrder productOrder) throws URISyntaxException {
        log.debug("REST request to update ProductOrder : {}", productOrder);
        ProductOrder result = productOrderService.save(productOrder);
        return ResponseEntity.ok()
            .body(result);
    }

    /**
     * GET  /product-orders : get all the productOrders.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of productOrders in body
     */
    @GetMapping("/product-orders")
    public List<ProductOrderDTO> getAllProductOrders() {
        log.debug("REST request to get all ProductOrders");
        return productOrderService.findAll()
        .stream()
        .map(productOrderMapper::toDto)
        .collect(Collectors.toList());
    }

    /**
     * GET  /product-orders/:id : get the "id" productOrder.
     *
     * @param id the id of the productOrder to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the productOrder, or with status 404 (Not Found)
     */
    @GetMapping("/product-orders/{id}")
    public ResponseEntity<ProductOrderDTO> getProductOrder(@PathVariable Long id) {
        log.debug("REST request to get ProductOrder : {}", id);
        Optional<ProductOrderDTO> productOrder = productOrderService.findOne(id)
        .map(productOrderMapper::toDto);
        return ResponseEntity.ok().body(productOrder.get());
    }

    /**
     * DELETE  /product-orders/:id : delete the "id" productOrder.
     *
     * @param id the id of the productOrder to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/product-orders/{id}")
    public ResponseEntity<Void> deleteProductOrder(@PathVariable Long id) {
        log.debug("REST request to delete ProductOrder : {}", id);
        productOrderService.delete(id);
        return ResponseEntity.ok().build();
    }
}
