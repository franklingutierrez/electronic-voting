package com.cavm.elecciones.escolares.respositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cavm.elecciones.escolares.models.Role;

public interface IRoleRepository extends CrudRepository<Role, Long> {
	List<Role> findAllByOrderByOrderr();
}
