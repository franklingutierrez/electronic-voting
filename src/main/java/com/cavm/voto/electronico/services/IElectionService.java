package com.cavm.voto.electronico.services;

import com.cavm.voto.electronico.models.Election;


public interface IElectionService {
	Election save(Election election);
	Election findFirstByOrderByIdAsc();
	Election findById(Long id);
}
