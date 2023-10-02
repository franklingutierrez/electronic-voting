package com.cavm.elecciones.escolares.respositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cavm.elecciones.escolares.models.CandidateList;

public interface ICandidateListRepository extends CrudRepository<CandidateList, Long> {
	List<CandidateList> findAllByOrderById();
}
