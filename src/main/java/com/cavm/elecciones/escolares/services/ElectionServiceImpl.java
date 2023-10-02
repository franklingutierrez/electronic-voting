package com.cavm.elecciones.escolares.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cavm.elecciones.escolares.models.Election;
import com.cavm.elecciones.escolares.respositories.IElectionRepository;

@Service
public class ElectionServiceImpl implements IElectionService {
	
	@Autowired
	private IElectionRepository electionRepository;
	
	@Override
	public Election save(Election election) {
		return electionRepository.save(election);
	}

	@Override
	public Election findFirstByOrderByIdAsc() {
		return electionRepository.findFirstByOrderByIdAsc();
	}

	@Override
	public Election findById(Long id) {
		return electionRepository.findById(id).get();
	}

}
