
package com.lxisoft.ekart.service.dto;

import java.io.Serializable;
import java.util.*;

import com.lxisoft.ekart.domain.ProductOrder;

/**
 * A Seller dto classes
 */

public class CustomerDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Long id;

    private String name;

    private String email;

    private String number;

    private Set<AddressDTO> addresses = new HashSet<>();

    private Set<ProductOrderDTO> productOrders = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public CustomerDTO name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public CustomerDTO email(String email) {
        this.email = email;
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public CustomerDTO number(String number) {
        this.number = number;
        return this;
    }

    public void setNumber(String number) {
        this.number = number;
    }

	public Set<AddressDTO> getAddresses()
	{
		return this.addresses;
	}

	public void setAddresses(Set<AddressDTO> addresses)
	{
		this.addresses = addresses;
    }

	public Set<ProductOrderDTO> getProductOrders()
	{
		return this.productOrders;
	}

	public void setProductOrders(Set<ProductOrderDTO> productOrders)
	{
		this.productOrders = productOrders;
	}



    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CustomerDTO seller = (CustomerDTO) o;
        if (seller.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), seller.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Seller{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", email='" + getEmail() + "'" +
            ", number='" + getNumber() + "'" +
            "}";
    }
}
