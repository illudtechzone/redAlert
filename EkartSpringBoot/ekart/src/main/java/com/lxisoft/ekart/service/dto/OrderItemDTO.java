package com.lxisoft.ekart.service.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Objects;
import java.util.*;

import com.lxisoft.ekart.domain.*;

/**
 * A OrderItemDTO.
 */

 public class OrderItemDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Long id;

    private Set<Product> products = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OrderItem orderItem = (OrderItem) o;
        if (orderItem.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), orderItem.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    public Set<Product> getProducts()
	{
		return this.products;
	}

	public void setProducts(Set<Product> products)
	{
		this.products = products;
	}



    @Override
    public String toString() {
        return "OrderItem{" +
            "id=" + getId() +
            "}";
    }
}
