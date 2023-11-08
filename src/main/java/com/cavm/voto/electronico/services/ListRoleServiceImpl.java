package com.cavm.voto.electronico.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional
	public ListRole save(ListRole listRole) {
		return listRoleRepository.save(listRole);
	}

	@Override
	@Transactional(readOnly = true)
	public void deleteById(Long id) {
		listRoleRepository.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ListRole> listRoleByList(Long id) {
		return listRoleRepository.listRoleByList(id);
	}

	@Override
	@Transactional(readOnly = true)
	public ListRole findById(Long id) {
		return listRoleRepository.findById(id).get();
	}

	@Override
	@Transactional(readOnly = true)
	public ListRole ListRoleByListAndRole(Long listId, Long rolId) {
		return listRoleRepository.ListRoleByListAndRole(listId, rolId);
	}

}
