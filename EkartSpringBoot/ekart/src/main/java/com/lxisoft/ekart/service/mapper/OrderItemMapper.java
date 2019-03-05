package com.lxisoft.ekart.service.mapper;

import com.lxisoft.ekart.domain.*;
import com.lxisoft.ekart.service.dto.*;
import com.lxisoft.ekart.service.mapper.*;

import org.mapstruct.*;
import org.springframework.stereotype.Component;

/**
 * Mapper for the entity Product and its DTO ProductDTO.
 */

@Mapper(componentModel = "spring", uses = {AddressMapper.class})
public interface OrderItemMapper extends EntityMapper<OrderItemDTO , OrderItem>{

    default Seller fromId(Long id) {
        if (id == null) {
            return null;
        }
        Seller seller = new Seller();
        seller.setId(id);
        return seller;
    }
}