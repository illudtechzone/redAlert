package com.illud.redalert.client.redalertmicroservice.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.illud.redalert.client.redalertmicroservice.model.FriendDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * FriendDTO
 */
@Validated
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-03-27T11:35:27.177+05:30[Asia/Kolkata]")

public class FriendDTO   {
  @JsonProperty("friends")
  @Valid
  private List<FriendDTO> friends = null;

  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("userId")
  private String userId = null;

  public FriendDTO friends(List<FriendDTO> friends) {
    this.friends = friends;
    return this;
  }

  public FriendDTO addFriendsItem(FriendDTO friendsItem) {
    if (this.friends == null) {
      this.friends = new ArrayList<FriendDTO>();
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

  public List<FriendDTO> getFriends() {
    return friends;
  }

  public void setFriends(List<FriendDTO> friends) {
    this.friends = friends;
  }

  public FriendDTO id(Long id) {
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

  public FriendDTO userId(String userId) {
    this.userId = userId;
    return this;
  }

  /**
   * Get userId
   * @return userId
  **/
  @ApiModelProperty(value = "")


  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FriendDTO friendDTO = (FriendDTO) o;
    return Objects.equals(this.friends, friendDTO.friends) &&
        Objects.equals(this.id, friendDTO.id) &&
        Objects.equals(this.userId, friendDTO.userId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(friends, id, userId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FriendDTO {\n");
    
    sb.append("    friends: ").append(toIndentedString(friends)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
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

