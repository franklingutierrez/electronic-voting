package com.cavm.voto.electronico.services;

import java.util.List;

import com.cavm.voto.electronico.models.User;


public interface IUserService {
	
	List<User> findAll();
	User validarUser(String username, String password);
	User save(User user);
}
