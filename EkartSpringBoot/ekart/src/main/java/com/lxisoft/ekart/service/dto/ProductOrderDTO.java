package com.lxisoft.ekart.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.*;
import com.lxisoft.ekart.domain.*;

/**
 * A ProductOrderDTO.
 */

public class ProductOrderDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Set<OrderItemDTO> orderItems = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<OrderItemDTO> getOrderItems()
	{
		return this.orderItems;
	}

	public void setOrderItems(Set<OrderItemDTO> orderItems)
	{
		this.orderItems = orderItems;
    }
    
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and
    // setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProductOrder productOrder = (ProductOrder) o;
        if (productOrder.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), productOrder.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ProductOrder{" + "id=" + getId() + "}";
    }
}
