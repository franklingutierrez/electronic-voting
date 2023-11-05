package com.cavm.voto.electronico.respositories;

import org.springframework.data.repository.CrudRepository;

import com.cavm.voto.electronico.models.Election;

public interface IElectionRepository extends CrudRepository<Election, Long> {
	Election findFirstByOrderByIdAsc();
}
