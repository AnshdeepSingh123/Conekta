package com.favourite.music.albums.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.favourite.music.albums.model.AlbumsModel;

public interface AlbumsRepository extends CrudRepository<AlbumsModel, String>
{
	@Query(value="SELECT t FROM AlbumsModel t WHERE t.user_id = :userId")
	List<AlbumsModel> findByUserId(@Param(value = "userId") String userId);
	
	@Query(value="SELECT t FROM AlbumsModel t WHERE t.user_id = :userId AND t.id = :albumId")
	List<AlbumsModel> findByUserIdAndAlbumId(@Param(value = "userId") String userId,@Param(value = "albumId") Integer albumId);

	@Modifying
	@Transactional
	@Query(value="DELETE FROM AlbumsModel a WHERE a.user_id = :userId AND a.id = :albumId")
	void deleteByUserIdAndAlbumId(@Param(value = "userId") String userId,@Param(value = "albumId") Integer albumId);
	
}
