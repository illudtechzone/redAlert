
package com.lxisoft.ekart.service.dto;

import java.io.Serializable;
import java.util.*;

/**
 * A Seller dto classes
 */

public class SellerDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Long id;

    private String name;

    private String email;

    private String number;

    private Set<AddressDTO> addresses = new HashSet<>();

/* @OneToOne(mappedBy = "seller")
    @JsonIgnore
    private Shop shop;
*/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public SellerDTO name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public SellerDTO email(String email) {
        this.email = email;
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public SellerDTO number(String number) {
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


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SellerDTO seller = (SellerDTO) o;
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
