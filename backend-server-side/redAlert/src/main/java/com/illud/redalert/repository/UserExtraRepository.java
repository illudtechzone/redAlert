package com.illud.redalert.repository;

import com.illud.redalert.domain.UserExtra;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data  repository for the UserExtra entity.
 */
@SuppressWarnings("unused")
@Repository
public interface UserExtraRepository extends JpaRepository<UserExtra, Long> {

    @Query(value = "select distinct user_extra from UserExtra user_extra left join fetch user_extra.friends",
        countQuery = "select count(distinct user_extra) from UserExtra user_extra")
    Page<UserExtra> findAllWithEagerRelationships(Pageable pageable);

    @Query(value = "select distinct user_extra from UserExtra user_extra left join fetch user_extra.friends")
    List<UserExtra> findAllWithEagerRelationships();

    Optional<UserExtra>  findByUserEmail(String userEmail);

}
