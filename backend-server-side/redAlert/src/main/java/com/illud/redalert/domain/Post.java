package com.illud.redalert.domain;


import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.illud.redalert.domain.enumeration.Alert;

/**
 * A Post.
 */
@Entity
@Table(name = "post")
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "created_on")
    private Instant createdOn;

    @Column(name = "description")
    private String description;

    @Column(name = "active")
    private Boolean active;

    @Enumerated(EnumType.STRING)
    @Column(name = "alert_level")
    private Alert alertLevel;

    @OneToOne
    @JoinColumn(unique = true)
    private Location location;

    @OneToMany(mappedBy = "post")
    private Set<Media> attachments = new HashSet<>();
    @OneToMany(mappedBy = "post")
    private Set<Comment> comments = new HashSet<>();
    @OneToMany(mappedBy = "post")
    private Set<Report> reports = new HashSet<>();
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

    public Post userId(String userId) {
        this.userId = userId;
        return this;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Instant getCreatedOn() {
        return createdOn;
    }

    public Post createdOn(Instant createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public void setCreatedOn(Instant createdOn) {
        this.createdOn = createdOn;
    }

    public String getDescription() {
        return description;
    }

    public Post description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean isActive() {
        return active;
    }

    public Post active(Boolean active) {
        this.active = active;
        return this;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Alert getAlertLevel() {
        return alertLevel;
    }

    public Post alertLevel(Alert alertLevel) {
        this.alertLevel = alertLevel;
        return this;
    }

    public void setAlertLevel(Alert alertLevel) {
        this.alertLevel = alertLevel;
    }

    public Location getLocation() {
        return location;
    }

    public Post location(Location location) {
        this.location = location;
        return this;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Set<Media> getAttachments() {
        return attachments;
    }

    public Post attachments(Set<Media> media) {
        this.attachments = media;
        return this;
    }

    public Post addAttachments(Media media) {
        this.attachments.add(media);
        media.setPost(this);
        return this;
    }

    public Post removeAttachments(Media media) {
        this.attachments.remove(media);
        media.setPost(null);
        return this;
    }

    public void setAttachments(Set<Media> media) {
        this.attachments = media;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public Post comments(Set<Comment> comments) {
        this.comments = comments;
        return this;
    }

    public Post addComments(Comment comment) {
        this.comments.add(comment);
        comment.setPost(this);
        return this;
    }

    public Post removeComments(Comment comment) {
        this.comments.remove(comment);
        comment.setPost(null);
        return this;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public Set<Report> getReports() {
        return reports;
    }

    public Post reports(Set<Report> reports) {
        this.reports = reports;
        return this;
    }

    public Post addReports(Report report) {
        this.reports.add(report);
        report.setPost(this);
        return this;
    }

    public Post removeReports(Report report) {
        this.reports.remove(report);
        report.setPost(null);
        return this;
    }

    public void setReports(Set<Report> reports) {
        this.reports = reports;
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
        Post post = (Post) o;
        if (post.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), post.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Post{" +
            "id=" + getId() +
            ", userId='" + getUserId() + "'" +
            ", createdOn='" + getCreatedOn() + "'" +
            ", description='" + getDescription() + "'" +
            ", active='" + isActive() + "'" +
            ", alertLevel='" + getAlertLevel() + "'" +
            "}";
    }
}
