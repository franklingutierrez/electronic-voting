package com.cavm.voto.electronico.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cavm.voto.electronico.models.ListRole;
import com.cavm.voto.electronico.respositories.IListRoleRepository;

@Service
public class ListRoleServiceImpl implements IListRoleService {
	
	@Autowired
	private IListRoleRepository listRoleRepository;
	
	@Override
	public List<ListRole> findAllByOrderByRoleOrder() {
		return listRoleRepository.orderListRoleOrder();
	}

	@Override
	public ListRole save(ListRole listRole) {
		return listRoleRepository.save(listRole);
	}

	@Override
	public void deleteById(Long id) {
		listRoleRepository.deleteById(id);
	}

	@Override
	public List<ListRole> listRoleByList(Long id) {
		return listRoleRepository.listRoleByList(id);
	}

	@Override
	public ListRole findById(Long id) {
		return listRoleRepository.findById(id).get();
	}

	@Override
	public ListRole ListRoleByListAndRole(Long listId, Long rolId) {
		return listRoleRepository.ListRoleByListAndRole(listId, rolId);
	}

}
