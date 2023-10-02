package com.cavm.elecciones.escolares.services;

import java.util.List;

import com.cavm.elecciones.escolares.models.ListRole;

public interface IListRoleService {
	List<ListRole> findAllByOrderByRoleOrder();
	ListRole save(ListRole listRole);
	void deleteById(Long id);
	List<ListRole> listRoleByList(Long id);
	ListRole findById(Long id);
	ListRole ListRoleByListAndRole(Long listId, Long rolId);
}
