package com.cavm.elecciones.escolares.services;

import java.util.List;

import com.cavm.elecciones.escolares.models.CandidateList;

public interface ICandidateListService {
	List<CandidateList> findAllByOrderById();
	CandidateList save(CandidateList candidateList);
	void delete(Long id);
	CandidateList findById(Long id);
}
