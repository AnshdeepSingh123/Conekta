package com.favourite.music.user.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.favourite.music.user.model.UsersModel;
import com.favourite.music.user.repository.UsersRepository;

@Service
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UsersDAO {
	
	@Autowired
	UsersRepository usersRepository;
	
	/* To save the User */
	
	public UsersModel saveUser(UsersModel user)
	{
		return usersRepository.save(user);
	}
	
	/* To search all Users */
	
	public List <UsersModel> findAllUsers()
	{
		return usersRepository.findAll();
	}
	
	/* To search single User by Id */
	
	public UsersModel findOneUser(Long userId) 
	{
		return usersRepository.getOne(userId);
	}
	
	/* To delete User */
	
	public void deleteUser(UsersModel user)
	{
		usersRepository.delete(user);
	}
	
	public void deleteAlbumIfUserDeleted(String userId)
	{
		usersRepository.deleteAlbumsIfUserDeleted(userId);
	}
}
