package com.cavm.elecciones.escolares.services;

import java.util.List;

import com.cavm.elecciones.escolares.models.Role;

public interface IRoleService {
	
	List<Role> findAllByOrderByOrder();
	Role save(Role role);
	Role findById(Long id);
	void deleteById(Long id);
	
}
