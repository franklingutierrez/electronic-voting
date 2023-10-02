package com.cavm.elecciones.escolares.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cavm.elecciones.escolares.models.Role;
import com.cavm.elecciones.escolares.respositories.IRoleRepository;

@Service
public class RoleServiceImpl implements IRoleService {
	
	@Autowired
	IRoleRepository roleRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Role> findAllByOrderByOrder() {
		return roleRepository.findAllByOrderByOrderr();
	}

	@Override
	@Transactional
	public Role save(Role role) {
		return roleRepository.save(role);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		roleRepository.deleteById(id);
	}

	@Override
	public Role findById(Long id) {
		return roleRepository.findById(id).get();
	}

}
