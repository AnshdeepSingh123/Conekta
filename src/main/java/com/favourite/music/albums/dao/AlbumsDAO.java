package com.favourite.music.albums.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.favourite.music.albums.model.AlbumsModel;
import com.favourite.music.albums.repository.AlbumsRepository;

@Service
public class AlbumsDAO {
	
	
	@Autowired
	private AlbumsRepository albumsRepository;
	
	/* To find All the Albums */
	
	public List<AlbumsModel> findAlbumByUserId(String userId)
	{
		return albumsRepository.findByUserId(userId);
	}
	
	/* To find the Albums by Albums Id */
	
	public List<AlbumsModel> findAlbumByUserIdAndAlbumId(String userId,Integer albumId)
	{
		return albumsRepository.findByUserIdAndAlbumId(userId,albumId);
	}

	/* To save the Albums */
	
	public AlbumsModel saveAlbumByUserId(AlbumsModel albumsModel)
	{
		return albumsRepository.save(albumsModel);
	}
	
	/* To delete the Albums */
	
	public void deleteAlbumByUserIdAndAlbumId(String userId,Integer albumId)
	{
		albumsRepository.deleteByUserIdAndAlbumId(userId,albumId);
	}
	
	
}
