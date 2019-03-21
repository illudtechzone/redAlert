package com.illud.redalert.repository;

import com.illud.redalert.domain.Report;
import com.illud.redalert.service.dto.ReportDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Report entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {

	Page<Report> findAllReportsByPostId(Long postId, Pageable pageable);

}
