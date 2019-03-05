package com.lxisoft.ekart.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Objects;
import java.util.*;

/**
 * A OrderItem.
 */
@Entity
@Table(name = "order_item")
public class OrderItem implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @NotNull
    @JoinTable(name = "order_item_product",
               joinColumns = @JoinColumn(name = "order_item_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"))
    private Set<Product> products = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties("orderItems")
    private ProductOrder productOrder;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductOrder getProductOrder() {
        return productOrder;
    }

    public OrderItem productOrder(ProductOrder productOrder) {
        this.productOrder = productOrder;
        return this;
    }

    public void setProductOrder(ProductOrder productOrder) {
        this.productOrder = productOrder;
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
