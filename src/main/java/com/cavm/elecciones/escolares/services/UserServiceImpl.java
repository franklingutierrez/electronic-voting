package com.cavm.elecciones.escolares.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cavm.elecciones.escolares.models.User;
import com.cavm.elecciones.escolares.respositories.IUserRepository;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private IUserRepository userRepository;
	
	@Override
	public List<User> findAll() {
		
		return (List<User>) userRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public User validarUser(String username, String password) {
		
		return userRepository.validateUser(username, password);
	}

	@Override
	@Transactional
	public User save(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

}
