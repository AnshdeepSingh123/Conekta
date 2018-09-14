package com.favourite.music.user.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.favourite.music.user.dao.UsersDAO;
import com.favourite.music.user.model.UsersModel;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UserController {
	
	@Autowired
	UsersDAO usersDAO;
	
	@ApiOperation(value="Add User")
	@ApiResponses(value= {
			@ApiResponse(code=200, message="Successfully retrived albums"),
			@ApiResponse(code=401, message="You are not authorized to view this resource"),
			@ApiResponse(code=403, message="Accessing the resource you are trying to reach is forbidden"),
			@ApiResponse(code=404, message="Resource you are trying to reach is not found"),
			@ApiResponse(code=500, message="Entered wrong path or URL")
	})
	
	/* To save the User */
	
	@PostMapping("/users/new")
	public UsersModel createUser(@Valid @RequestBody UsersModel users)
	{
		return usersDAO.saveUser(users);
	}

	@ApiOperation(value="Get All Users",response=List.class)
	@ApiResponses(value= {
			@ApiResponse(code=200, message="Successfully retrived albums"),
			@ApiResponse(code=401, message="You are not authorized to view this resource"),
			@ApiResponse(code=403, message="Accessing the resource you are trying to reach is forbidden"),
			@ApiResponse(code=404, message="Resource you are trying to reach is not found"),
			@ApiResponse(code=500, message="Entered wrong path or URL")
	})
	
	/* To get all Users */
	
	@GetMapping("/users")
	public List<UsersModel> getAllUsers()
	{
		return usersDAO.findAllUsers();
	}
	
	@ApiOperation(value="Get User With Specific Id")
	@ApiResponses(value= {
			@ApiResponse(code=200, message="Successfully retrived albums"),
			@ApiResponse(code=401, message="You are not authorized to view this resource"),
			@ApiResponse(code=403, message="Accessing the resource you are trying to reach is forbidden"),
			@ApiResponse(code=404, message="Resource you are trying to reach is not found"),
			@ApiResponse(code=500, message="Entered wrong path or URL")
	})
	
	/* To get the User by Id*/
	
	@GetMapping("/users/{id}")
	public ResponseEntity<UsersModel> getUserByName(@PathVariable(value="id") Long userId)
	{
		UsersModel users=usersDAO.findOneUser(userId);
		
		if(users==null)
		{
			
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok().body(users);
	}
	
	/* To update the User */
	
	@ApiOperation(value="Update User")
	@ApiResponses(value= {
			@ApiResponse(code=200, message="Successfully retrived albums"),
			@ApiResponse(code=401, message="You are not authorized to view this resource"),
			@ApiResponse(code=403, message="Accessing the resource you are trying to reach is forbidden"),
			@ApiResponse(code=404, message="Resource you are trying to reach is not found"),
			@ApiResponse(code=500, message="Entered wrong path or URL")
	})
	
	@PutMapping("/users/{id}")
	public ResponseEntity<UsersModel> updateUser(@PathVariable(value="id") Long userId, @Valid @RequestBody UsersModel users)
	{
		UsersModel user=usersDAO.findOneUser(userId);
		
		if(user==null)
		{
			return ResponseEntity.notFound().build();
		}
		
		user.setName(users.getName());
		user.setEmail(users.getEmail());
		user.setNumber(users.getNumber());
		
		return ResponseEntity.ok().body(usersDAO.saveUser(user));
	}
	
	@ApiOperation(value="Delete Specific User",response=List.class)
	@ApiResponses(value= {
			@ApiResponse(code=200, message="Successfully retrived albums"),
			@ApiResponse(code=401, message="You are not authorized to view this resource"),
			@ApiResponse(code=403, message="Accessing the resource you are trying to reach is forbidden"),
			@ApiResponse(code=404, message="Resource you are trying to reach is not found"),
			@ApiResponse(code=500, message="Entered wrong path or URL")
	})
	
	/* To Delete the User */
	@DeleteMapping("/users/{id}")
	public ResponseEntity<UsersModel> deleteUser(@PathVariable(value="id") Long userId,@PathVariable(value="id") String usersId)
	{
		UsersModel user=usersDAO.findOneUser(userId);
		
		if(user==null)
		{
			return ResponseEntity.notFound().build();
		}
		usersDAO.deleteUser(user);
		usersDAO.deleteAlbumIfUserDeleted(usersId);
		return ResponseEntity.ok().build();
	}
	
}
