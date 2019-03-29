package com.illud.redalert.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.illud.redalert.domain.FriendsList;

public interface FriendsListRepository extends JpaRepository<FriendsList, Long> {
	Optional<FriendsList>  findByUserEmail(String userEmail);
}
