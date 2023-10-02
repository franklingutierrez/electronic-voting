package com.cavm.elecciones.escolares.services;

import java.util.List;


import com.cavm.elecciones.escolares.models.User;


public interface IUserService {
	
	List<User> findAll();
	User validarUser(String username, String password);
	User save(User user);
}
