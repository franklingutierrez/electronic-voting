package com.cavm.voto.electronico.services;

import java.util.List;

import com.cavm.voto.electronico.models.ListRole;

public interface IListRoleService {
	List<ListRole> findAllByOrderByRoleOrder();
	ListRole save(ListRole listRole);
	void deleteById(Long id);
	List<ListRole> listRoleByList(Long id);
	ListRole findById(Long id);
	ListRole ListRoleByListAndRole(Long listId, Long rolId);
}
