package com.cavm.voto.electronico.services;

import java.util.List;

import com.cavm.voto.electronico.models.Role;

public interface IRoleService {
	
	List<Role> findAllByOrderByOrder();
	Role save(Role role);
	Role findById(Long id);
	void deleteById(Long id);
	
}
