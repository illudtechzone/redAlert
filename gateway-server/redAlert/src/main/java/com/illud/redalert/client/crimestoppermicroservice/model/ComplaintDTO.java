package com.illud.redalert.client.crimestoppermicroservice.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.illud.redalert.client.crimestoppermicroservice.model.CommentDTO;
import com.illud.redalert.client.crimestoppermicroservice.model.ComplaintDTO;
import com.illud.redalert.client.crimestoppermicroservice.model.DepartmentDTO;
import com.illud.redalert.client.crimestoppermicroservice.model.HashtagDTO;
import com.illud.redalert.client.crimestoppermicroservice.model.LocationDTO;
import com.illud.redalert.client.crimestoppermicroservice.model.UserResponseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ComplaintDTO
 */
@Validated
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-03-29T16:14:29.725+05:30[Asia/Kolkata]")

public class ComplaintDTO   {
  @JsonProperty("comments")
  @Valid
  private List<CommentDTO> comments = null;

  @JsonProperty("departments")
  @Valid
  private List<DepartmentDTO> departments = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("hashtags")
  @Valid
  private List<HashtagDTO> hashtags = null;

  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("image")
  private String image = null;

  @JsonProperty("linkedComplaints")
  @Valid
  private List<ComplaintDTO> linkedComplaints = null;

  @JsonProperty("location")
  private LocationDTO location = null;

  @JsonProperty("locationId")
  private Long locationId = null;

  @JsonProperty("media")
  private byte[] media = null;

  @JsonProperty("mediaContentType")
  private String mediaContentType = null;

  @JsonProperty("noOfDislikes")
  private Long noOfDislikes = null;

  @JsonProperty("noOfLikes")
  private Long noOfLikes = null;

  /**
   * Gets or Sets status
   */
  public enum StatusEnum {
    SEEN("SEEN"),
    
    ACTION_TAKEN("ACTION_TAKEN");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String text) {
      for (StatusEnum b : StatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("status")
  private StatusEnum status = null;

  @JsonProperty("subject")
  private String subject = null;

  @JsonProperty("time")
  private OffsetDateTime time = null;

  @JsonProperty("timeOfIncident")
  private OffsetDateTime timeOfIncident = null;

  @JsonProperty("userId")
  private Long userId = null;

  @JsonProperty("userName")
  private String userName = null;

  @JsonProperty("userResponse")
  private UserResponseDTO userResponse = null;

  public ComplaintDTO comments(List<CommentDTO> comments) {
    this.comments = comments;
    return this;
  }

  public ComplaintDTO addCommentsItem(CommentDTO commentsItem) {
    if (this.comments == null) {
      this.comments = new ArrayList<CommentDTO>();
    }
    this.comments.add(commentsItem);
    return this;
  }

  /**
   * Get comments
   * @return comments
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<CommentDTO> getComments() {
    return comments;
  }

  public void setComments(List<CommentDTO> comments) {
    this.comments = comments;
  }

  public ComplaintDTO departments(List<DepartmentDTO> departments) {
    this.departments = departments;
    return this;
  }

  public ComplaintDTO addDepartmentsItem(DepartmentDTO departmentsItem) {
    if (this.departments == null) {
      this.departments = new ArrayList<DepartmentDTO>();
    }
    this.departments.add(departmentsItem);
    return this;
  }

  /**
   * Get departments
   * @return departments
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<DepartmentDTO> getDepartments() {
    return departments;
  }

  public void setDepartments(List<DepartmentDTO> departments) {
    this.departments = departments;
  }

  public ComplaintDTO description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
  **/
  @ApiModelProperty(value = "")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ComplaintDTO hashtags(List<HashtagDTO> hashtags) {
    this.hashtags = hashtags;
    return this;
  }

  public ComplaintDTO addHashtagsItem(HashtagDTO hashtagsItem) {
    if (this.hashtags == null) {
      this.hashtags = new ArrayList<HashtagDTO>();
    }
    this.hashtags.add(hashtagsItem);
    return this;
  }

  /**
   * Get hashtags
   * @return hashtags
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<HashtagDTO> getHashtags() {
    return hashtags;
  }

  public void setHashtags(List<HashtagDTO> hashtags) {
    this.hashtags = hashtags;
  }

  public ComplaintDTO id(Long id) {
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

  public ComplaintDTO image(String image) {
    this.image = image;
    return this;
  }

  /**
   * Get image
   * @return image
  **/
  @ApiModelProperty(value = "")


  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public ComplaintDTO linkedComplaints(List<ComplaintDTO> linkedComplaints) {
    this.linkedComplaints = linkedComplaints;
    return this;
  }

  public ComplaintDTO addLinkedComplaintsItem(ComplaintDTO linkedComplaintsItem) {
    if (this.linkedComplaints == null) {
      this.linkedComplaints = new ArrayList<ComplaintDTO>();
    }
    this.linkedComplaints.add(linkedComplaintsItem);
    return this;
  }

  /**
   * Get linkedComplaints
   * @return linkedComplaints
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<ComplaintDTO> getLinkedComplaints() {
    return linkedComplaints;
  }

  public void setLinkedComplaints(List<ComplaintDTO> linkedComplaints) {
    this.linkedComplaints = linkedComplaints;
  }

  public ComplaintDTO location(LocationDTO location) {
    this.location = location;
    return this;
  }

  /**
   * Get location
   * @return location
  **/
  @ApiModelProperty(value = "")

  @Valid

  public LocationDTO getLocation() {
    return location;
  }

  public void setLocation(LocationDTO location) {
    this.location = location;
  }

  public ComplaintDTO locationId(Long locationId) {
    this.locationId = locationId;
    return this;
  }

  /**
   * Get locationId
   * @return locationId
  **/
  @ApiModelProperty(value = "")


  public Long getLocationId() {
    return locationId;
  }

  public void setLocationId(Long locationId) {
    this.locationId = locationId;
  }

  public ComplaintDTO media(byte[] media) {
    this.media = media;
    return this;
  }

  /**
   * Get media
   * @return media
  **/
  @ApiModelProperty(value = "")

@Pattern(regexp="^(?:[A-Za-z0-9+/]{4})*(?:[A-Za-z0-9+/]{2}==|[A-Za-z0-9+/]{3}=)?$") 
  public byte[] getMedia() {
    return media;
  }

  public void setMedia(byte[] media) {
    this.media = media;
  }

  public ComplaintDTO mediaContentType(String mediaContentType) {
    this.mediaContentType = mediaContentType;
    return this;
  }

  /**
   * Get mediaContentType
   * @return mediaContentType
  **/
  @ApiModelProperty(value = "")


  public String getMediaContentType() {
    return mediaContentType;
  }

  public void setMediaContentType(String mediaContentType) {
    this.mediaContentType = mediaContentType;
  }

  public ComplaintDTO noOfDislikes(Long noOfDislikes) {
    this.noOfDislikes = noOfDislikes;
    return this;
  }

  /**
   * Get noOfDislikes
   * @return noOfDislikes
  **/
  @ApiModelProperty(value = "")


  public Long getNoOfDislikes() {
    return noOfDislikes;
  }

  public void setNoOfDislikes(Long noOfDislikes) {
    this.noOfDislikes = noOfDislikes;
  }

  public ComplaintDTO noOfLikes(Long noOfLikes) {
    this.noOfLikes = noOfLikes;
    return this;
  }

  /**
   * Get noOfLikes
   * @return noOfLikes
  **/
  @ApiModelProperty(value = "")


  public Long getNoOfLikes() {
    return noOfLikes;
  }

  public void setNoOfLikes(Long noOfLikes) {
    this.noOfLikes = noOfLikes;
  }

  public ComplaintDTO status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(value = "")


  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public ComplaintDTO subject(String subject) {
    this.subject = subject;
    return this;
  }

  /**
   * Get subject
   * @return subject
  **/
  @ApiModelProperty(value = "")


  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public ComplaintDTO time(OffsetDateTime time) {
    this.time = time;
    return this;
  }

  /**
   * Get time
   * @return time
  **/
  @ApiModelProperty(value = "")

  @Valid

  public OffsetDateTime getTime() {
    return time;
  }

  public void setTime(OffsetDateTime time) {
    this.time = time;
  }

  public ComplaintDTO timeOfIncident(OffsetDateTime timeOfIncident) {
    this.timeOfIncident = timeOfIncident;
    return this;
  }

  /**
   * Get timeOfIncident
   * @return timeOfIncident
  **/
  @ApiModelProperty(value = "")

  @Valid

  public OffsetDateTime getTimeOfIncident() {
    return timeOfIncident;
  }

  public void setTimeOfIncident(OffsetDateTime timeOfIncident) {
    this.timeOfIncident = timeOfIncident;
  }

  public ComplaintDTO userId(Long userId) {
    this.userId = userId;
    return this;
  }

  /**
   * Get userId
   * @return userId
  **/
  @ApiModelProperty(value = "")


  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public ComplaintDTO userName(String userName) {
    this.userName = userName;
    return this;
  }

  /**
   * Get userName
   * @return userName
  **/
  @ApiModelProperty(value = "")


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public ComplaintDTO userResponse(UserResponseDTO userResponse) {
    this.userResponse = userResponse;
    return this;
  }

  /**
   * Get userResponse
   * @return userResponse
  **/
  @ApiModelProperty(value = "")

  @Valid

  public UserResponseDTO getUserResponse() {
    return userResponse;
  }

  public void setUserResponse(UserResponseDTO userResponse) {
    this.userResponse = userResponse;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ComplaintDTO complaintDTO = (ComplaintDTO) o;
    return Objects.equals(this.comments, complaintDTO.comments) &&
        Objects.equals(this.departments, complaintDTO.departments) &&
        Objects.equals(this.description, complaintDTO.description) &&
        Objects.equals(this.hashtags, complaintDTO.hashtags) &&
        Objects.equals(this.id, complaintDTO.id) &&
        Objects.equals(this.image, complaintDTO.image) &&
        Objects.equals(this.linkedComplaints, complaintDTO.linkedComplaints) &&
        Objects.equals(this.location, complaintDTO.location) &&
        Objects.equals(this.locationId, complaintDTO.locationId) &&
        Objects.equals(this.media, complaintDTO.media) &&
        Objects.equals(this.mediaContentType, complaintDTO.mediaContentType) &&
        Objects.equals(this.noOfDislikes, complaintDTO.noOfDislikes) &&
        Objects.equals(this.noOfLikes, complaintDTO.noOfLikes) &&
        Objects.equals(this.status, complaintDTO.status) &&
        Objects.equals(this.subject, complaintDTO.subject) &&
        Objects.equals(this.time, complaintDTO.time) &&
        Objects.equals(this.timeOfIncident, complaintDTO.timeOfIncident) &&
        Objects.equals(this.userId, complaintDTO.userId) &&
        Objects.equals(this.userName, complaintDTO.userName) &&
        Objects.equals(this.userResponse, complaintDTO.userResponse);
  }

  @Override
  public int hashCode() {
    return Objects.hash(comments, departments, description, hashtags, id, image, linkedComplaints, location, locationId, media, mediaContentType, noOfDislikes, noOfLikes, status, subject, time, timeOfIncident, userId, userName, userResponse);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ComplaintDTO {\n");
    
    sb.append("    comments: ").append(toIndentedString(comments)).append("\n");
    sb.append("    departments: ").append(toIndentedString(departments)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    hashtags: ").append(toIndentedString(hashtags)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    image: ").append(toIndentedString(image)).append("\n");
    sb.append("    linkedComplaints: ").append(toIndentedString(linkedComplaints)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    locationId: ").append(toIndentedString(locationId)).append("\n");
    sb.append("    media: ").append(toIndentedString(media)).append("\n");
    sb.append("    mediaContentType: ").append(toIndentedString(mediaContentType)).append("\n");
    sb.append("    noOfDislikes: ").append(toIndentedString(noOfDislikes)).append("\n");
    sb.append("    noOfLikes: ").append(toIndentedString(noOfLikes)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    subject: ").append(toIndentedString(subject)).append("\n");
    sb.append("    time: ").append(toIndentedString(time)).append("\n");
    sb.append("    timeOfIncident: ").append(toIndentedString(timeOfIncident)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    userName: ").append(toIndentedString(userName)).append("\n");
    sb.append("    userResponse: ").append(toIndentedString(userResponse)).append("\n");
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

