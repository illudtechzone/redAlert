package com.lxisoft.ekart.service.dto;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.lxisoft.ekart.domain.Image;
import com.lxisoft.ekart.service.dto.CategoryTestDTO;

import java.util.Objects;

/**
 * A DTO for the Product entity.
 */
public class ProductDTO implements Serializable {

    private Long id;

    private String name;

    private String description;

    private Long shopId;

    private Double price;

    private String shopName;
    
    private Image image;

    private Set<CategoryTestDTO> categories;

	public Set<CategoryTestDTO> getCategories()
	{
		return this.categories;
	}

	public void setCategories(Set<CategoryTestDTO> categories)
	{
		this.categories = categories;
	}


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

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }
	public String getShopName()
	{
		return this.shopName;
	}

	public void setShopName(String shopName)
	{
		this.shopName = shopName;
	}

	public Image getImage()
	{
		return this.image;
	}

	public void setImage(Image image)
	{
		this.image = image;
	}

    public Double getPrice()
	{
		return this.price;
	}

	public void setPrice(Double price)
	{
		this.price = price;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ProductDTO productDTO = (ProductDTO) o;
        if (productDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), productDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            ", shop=" + getShopId() +
            "}";
    }
}
