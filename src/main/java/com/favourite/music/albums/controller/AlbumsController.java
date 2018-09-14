package com.favourite.music.albums.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.favourite.music.albums.dao.AlbumsDAO;
import com.favourite.music.albums.model.AlbumsModel;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Api(value="Album Store")
public class AlbumsController {
	
	
	@Autowired
	private AlbumsDAO albumsDAO; 
	
	@ApiOperation(value="View All Albums By User",response=List.class)
	@ApiResponses(value= {
			@ApiResponse(code=200, message="Successfully retrived albums"),
			@ApiResponse(code=401, message="You are not authorized to view this resource"),
			@ApiResponse(code=403, message="Accessing the resource you are trying to reach is forbidden"),
			@ApiResponse(code=404, message="Resource you are trying to reach is not found"),
			@ApiResponse(code=500, message="Entered wrong path or URL")
	})
	
	/* To get all Albums */
	
	@GetMapping("users/{userId}/albums")
	public List<AlbumsModel> getAllAlbumByUser(@PathVariable(value="userId") String userId)
	{
		List<AlbumsModel> albumsList=albumsDAO.findAlbumByUserId(userId);
		
		return albumsList;
	}
	
	@ApiOperation(value="View Specific Album By User",response=List.class)
	@ApiResponses(value= {
			@ApiResponse(code=200, message="Successfully retrived albums"),
			@ApiResponse(code=401, message="You are not authorized to view this resource"),
			@ApiResponse(code=403, message="Accessing the resource you are trying to reach is forbidden"),
			@ApiResponse(code=404, message="Resource you are trying to reach is not found"),
			@ApiResponse(code=500, message="Entered wrong path or URL")
	})
	
	/* To get the Album by Id*/
	
	@GetMapping("users/{userId}/albums/{albumId}")
	public List<AlbumsModel> getSpecificAlbumByUserId(@PathVariable(value="userId") String userId,@PathVariable(value="albumId") Integer albumId)
	{
		List<AlbumsModel> albumsList=albumsDAO.findAlbumByUserIdAndAlbumId(userId, albumId);
		
		return albumsList;
	}
	
	@ApiOperation(value="Add Albums By User",response=String.class)
	@ApiResponses(value= {
			@ApiResponse(code=200, message="Successfully retrived albums"),
			@ApiResponse(code=401, message="You are not authorized to view this resource"),
			@ApiResponse(code=403, message="Accessing the resource you are trying to reach is forbidden"),
			@ApiResponse(code=404, message="Resource you are trying to reach is not found"),
			@ApiResponse(code=500, message="Entered wrong path or URL")
	})
	
	/* To save the Album */
	
	@PostMapping("users/{userId}/albums/new")
	public String createAlbum(@PathVariable(value="userId") String userId,@Valid @RequestBody AlbumsModel albumsModel)
	{
		albumsModel.setUser_id(userId);
		
		if(Integer.parseInt(albumsModel.getRating())>10 || Integer.parseInt(albumsModel.getRating())<1 )
		{
			return "Rating can be between 1 to 10";
		}
		
	    albumsDAO.saveAlbumByUserId(albumsModel);
	    
	    return "Album Added";
	}
	
	@ApiOperation(value="Delete Specific Albums By Users")
	@ApiResponses(value= {
			@ApiResponse(code=200, message="Successfully retrived albums"),
			@ApiResponse(code=401, message="You are not authorized to view this resource"),
			@ApiResponse(code=403, message="Accessing the resource you are trying to reach is forbidden"),
			@ApiResponse(code=404, message="Resource you are trying to reach is not found"),
			@ApiResponse(code=500, message="Entered wrong path or URL")
	})
	
	/* To delete the Album */
	
	@DeleteMapping("users/{userId}/albums/{albumId}")
	public void deleteSpecificAlbumByUser(@PathVariable(value="userId") String userId,@PathVariable(value="albumId") Integer albumId)
	{
		albumsDAO.deleteAlbumByUserIdAndAlbumId(userId,albumId);
		
	}

}
