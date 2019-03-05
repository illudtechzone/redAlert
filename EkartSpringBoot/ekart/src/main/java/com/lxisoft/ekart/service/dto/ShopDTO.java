package com.lxisoft.ekart.service.dto;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.lxisoft.ekart.domain.Product;

/**
 * A DTO for the Shop entity.
 */
public class ShopDTO implements Serializable {

    private Long id;

    private String name;

    private String description;

    private Long sellerId;

    private String sellerName;

    private String sellerEmail;

    private Set<ProductDTO> products = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public String getSellerName()
	{
		return this.sellerName;
	}

	public void setSellerName(String sellerName)
	{
		this.sellerName = sellerName;
    }
    
    public String getSellerEmail()
	{
		return this.sellerEmail;
	}

	public void setSellerEmail(String sellerEmail)
	{
		this.sellerEmail = sellerEmail;
    }
    
    public Set<ProductDTO> getProducts()
	{
		return this.products;
	}

	public void setProducts(Set<ProductDTO> products)
	{
		this.products = products;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ShopDTO shopDTO = (ShopDTO) o;
        if (shopDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), shopDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ShopDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            ", seller=" + getSellerId() +
            "}";
    }
}
