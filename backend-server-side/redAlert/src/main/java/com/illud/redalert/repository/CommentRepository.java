package com.illud.redalert.repository;

import com.illud.redalert.domain.Comment;
import com.illud.redalert.domain.Post;
import com.illud.redalert.service.dto.PostDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Comment entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

	Page<Comment> findByPostId(Long postId, Pageable pageable);

}
