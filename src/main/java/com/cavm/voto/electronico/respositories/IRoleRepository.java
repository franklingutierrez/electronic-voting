package com.cavm.voto.electronico.respositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cavm.voto.electronico.models.Role;

public interface IRoleRepository extends CrudRepository<Role, Long> {
	List<Role> findAllByOrderByOrderr();
}
