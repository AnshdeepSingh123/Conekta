package com.favourite.music.user.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.favourite.music.user.model.UsersModel;

public interface UsersRepository extends JpaRepository<UsersModel, Long>
{

	@Modifying
	@Transactional
	@Query(value="DELETE FROM AlbumsModel a WHERE a.user_id = :userId")
	void deleteAlbumsIfUserDeleted(@Param(value = "userId") String userId);
}
