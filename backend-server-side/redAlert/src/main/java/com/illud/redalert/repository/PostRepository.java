package com.illud.redalert.repository;

import com.illud.redalert.domain.Post;

import java.awt.print.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Post entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
	Page<Post> findByuserId(Long userId,Pageable pageable);
}
