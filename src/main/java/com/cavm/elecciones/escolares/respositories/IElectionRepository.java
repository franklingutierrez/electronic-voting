package com.cavm.elecciones.escolares.respositories;

import org.springframework.data.repository.CrudRepository;

import com.cavm.elecciones.escolares.models.Election;

public interface IElectionRepository extends CrudRepository<Election, Long> {
	Election findFirstByOrderByIdAsc();
}
