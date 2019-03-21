package com.illud.redalert.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A Friend.
 */
@Entity
@Table(name = "friend")
public class Friend implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private String userId;

    @ManyToMany
    @JoinTable(name = "friend_friends",
               joinColumns = @JoinColumn(name = "friend_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "friends_id", referencedColumnName = "id"))
    private Set<Friend> friends = new HashSet<>();

    @ManyToMany(mappedBy = "friends")
    @JsonIgnore
    private Set<Friend> users = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public Friend userId(String userId) {
        this.userId = userId;
        return this;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Set<Friend> getFriends() {
        return friends;
    }

    public Friend friends(Set<Friend> friends) {
        this.friends = friends;
        return this;
    }

    public Friend addFriends(Friend friend) {
        this.friends.add(friend);
        friend.getUsers().add(this);
        return this;
    }

    public Friend removeFriends(Friend friend) {
        this.friends.remove(friend);
        friend.getUsers().remove(this);
        return this;
    }

    public void setFriends(Set<Friend> friends) {
        this.friends = friends;
    }

    public Set<Friend> getUsers() {
        return users;
    }

    public Friend users(Set<Friend> friends) {
        this.users = friends;
        return this;
    }

    public Friend addUsers(Friend friend) {
        this.users.add(friend);
        friend.getFriends().add(this);
        return this;
    }

    public Friend removeUsers(Friend friend) {
        this.users.remove(friend);
        friend.getFriends().remove(this);
        return this;
    }

    public void setUsers(Set<Friend> friends) {
        this.users = friends;
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
        Friend friend = (Friend) o;
        if (friend.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), friend.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Friend{" +
            "id=" + getId() +
            ", userId='" + getUserId() + "'" +
            "}";
    }
}
