package com.lxisoft.ekart.service.mapper;

import com.lxisoft.ekart.domain.*;
import com.lxisoft.ekart.service.dto.*;

import org.mapstruct.*;

/**
 * Mapper for the entity Product and its DTO ProductDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ProductOrderMapper extends EntityMapper<ProductOrderDTO , ProductOrder>{

    default Address fromId(Long id) {
        if (id == null) {
            return null;
        }
        Address address = new Address();
        address.setId(id);
        return address;
    }
}