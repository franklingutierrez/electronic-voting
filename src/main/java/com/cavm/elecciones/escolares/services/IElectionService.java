package com.cavm.elecciones.escolares.services;

import com.cavm.elecciones.escolares.models.Election;


public interface IElectionService {
	Election save(Election election);
	Election findFirstByOrderByIdAsc();
	Election findById(Long id);
}
