package com.cavm.voto.electronico.services;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cavm.voto.electronico.models.RoleUser;
import com.cavm.voto.electronico.models.User;
import com.cavm.voto.electronico.respositories.IUserRepository;


@Service
public class UserServiceImpl implements UserDetailsService /*IUserService*/ {
	
	@Autowired
	private IUserRepository userRepository;
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if(user == null) {
			System.out.println("hollallalala");
			throw new UsernameNotFoundException("Username "+username + " no existe");
		}
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for(RoleUser role : user.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		if(authorities.isEmpty()) {
			throw new UsernameNotFoundException("Username "+username + " no tiene roles asignados");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.getState(), true, true, true, authorities);
	}
	
	/*@Autowired
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
	}*/

}
