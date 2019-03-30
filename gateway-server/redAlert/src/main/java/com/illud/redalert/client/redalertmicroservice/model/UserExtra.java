package com.illud.redalert.client.redalertmicroservice.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.illud.redalert.client.redalertmicroservice.model.FriendsList;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * UserExtra
 */
@Validated
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-03-29T19:09:02.345873+05:30[Asia/Calcutta]")

public class UserExtra   {
  @JsonProperty("friends")
  @Valid
  private List<FriendsList> friends = null;

  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("userEmail")
  private String userEmail = null;

  public UserExtra friends(List<FriendsList> friends) {
    this.friends = friends;
    return this;
  }

  public UserExtra addFriendsItem(FriendsList friendsItem) {
    if (this.friends == null) {
      this.friends = new ArrayList<FriendsList>();
    }
    this.friends.add(friendsItem);
    return this;
  }

  /**
   * Get friends
   * @return friends
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<FriendsList> getFriends() {
    return friends;
  }

  public void setFriends(List<FriendsList> friends) {
    this.friends = friends;
  }

  public UserExtra id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public UserExtra userEmail(String userEmail) {
    this.userEmail = userEmail;
    return this;
  }

  /**
   * Get userEmail
   * @return userEmail
  **/
  @ApiModelProperty(value = "")


  public String getUserEmail() {
    return userEmail;
  }

  public void setUserEmail(String userEmail) {
    this.userEmail = userEmail;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserExtra userExtra = (UserExtra) o;
    return Objects.equals(this.friends, userExtra.friends) &&
        Objects.equals(this.id, userExtra.id) &&
        Objects.equals(this.userEmail, userExtra.userEmail);
  }

  @Override
  public int hashCode() {
    return Objects.hash(friends, id, userEmail);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserExtra {\n");
    
    sb.append("    friends: ").append(toIndentedString(friends)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    userEmail: ").append(toIndentedString(userEmail)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

