package com.cavm.voto.electronico.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cavm.voto.electronico.models.Election;
import com.cavm.voto.electronico.respositories.IElectionRepository;

@Service
public class ElectionServiceImpl implements IElectionService {
	
	@Autowired
	private IElectionRepository electionRepository;
	
	@Override
	@Transactional
	public Election save(Election election) {
		return electionRepository.save(election);
	}

	@Override
	@Transactional(readOnly = true)
	public Election findFirstByOrderByIdAsc() {
		return electionRepository.findFirstByOrderByIdAsc();
	}

	@Override
	@Transactional(readOnly = true)
	public Election findById(Long id) {
		return electionRepository.findById(id).get();
	}

}
