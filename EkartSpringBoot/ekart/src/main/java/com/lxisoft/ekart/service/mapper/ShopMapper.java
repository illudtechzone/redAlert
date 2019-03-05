package com.lxisoft.ekart.service.mapper;

import com.lxisoft.ekart.domain.*;
import com.lxisoft.ekart.service.dto.ShopDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Shop and its DTO ShopDTO.
 */
@Mapper(componentModel = "spring", uses = {SellerMapper.class})
public interface ShopMapper extends EntityMapper<ShopDTO, Shop> {

    @Mapping(source = "seller.id", target = "sellerId")
    @Mapping(source = "seller.name", target = "sellerName")
    @Mapping(source = "seller.email", target = "sellerEmail")
    ShopDTO toDto(Shop shop);

    @Mapping(source = "sellerId", target = "seller")
    Shop toEntity(ShopDTO shopDTO);

    default Shop fromId(Long id) {
        if (id == null) {
            return null;
        }
        Shop shop = new Shop();
        shop.setId(id);
        return shop;
    }
}
