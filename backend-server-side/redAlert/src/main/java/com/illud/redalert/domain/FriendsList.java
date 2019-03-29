package com.illud.redalert.domain;



import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A FriendsList.
 */
@Entity
@Table(name = "friends_list")
public class FriendsList implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_email")
    private String userEmail;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public FriendsList userEmail(String userEmail) {
        this.userEmail = userEmail;
        return this;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FriendsList friendsList = (FriendsList) o;
        if (friendsList.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), friendsList.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "FriendsList{" +
            "id=" + getId() +
            ", userEmail='" + getUserEmail() + "'" +
            "}";
    }
}
