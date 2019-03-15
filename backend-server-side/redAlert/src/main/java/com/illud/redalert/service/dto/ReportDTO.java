package com.illud.redalert.service.dto;
import java.io.Serializable;
import java.util.Objects;
import com.illud.redalert.domain.enumeration.ReportType;

/**
 * A DTO for the Report entity.
 */
public class ReportDTO implements Serializable {

    private Long id;

    private Long userId;

    private String reason;

    private ReportType reportType;


    private Long postId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ReportType getReportType() {
        return reportType;
    }

    public void setReportType(ReportType reportType) {
        this.reportType = reportType;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ReportDTO reportDTO = (ReportDTO) o;
        if (reportDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), reportDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ReportDTO{" +
            "id=" + getId() +
            ", userId=" + getUserId() +
            ", reason='" + getReason() + "'" +
            ", reportType='" + getReportType() + "'" +
            ", post=" + getPostId() +
            "}";
    }
}
