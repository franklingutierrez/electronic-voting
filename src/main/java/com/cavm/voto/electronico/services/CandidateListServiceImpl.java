package com.cavm.voto.electronico.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cavm.voto.electronico.models.CandidateList;
import com.cavm.voto.electronico.respositories.ICandidateListRepository;

@Service
public class CandidateListServiceImpl implements ICandidateListService {
	
	@Autowired
	ICandidateListRepository candidateListRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<CandidateList> findAllByOrderById() {
		return candidateListRepository.findAllByOrderById();
	}

	@Override
	@Transactional
	public CandidateList save(CandidateList candidateList) {
		return candidateListRepository.save(candidateList);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		candidateListRepository.deleteById(id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public CandidateList findById(Long id) {
		return candidateListRepository.findById(id).get();
	} 

}
