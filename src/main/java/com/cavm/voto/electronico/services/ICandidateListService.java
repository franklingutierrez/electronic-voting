package com.cavm.voto.electronico.services;

import java.util.List;

import com.cavm.voto.electronico.models.CandidateList;

public interface ICandidateListService {
	List<CandidateList> findAllByOrderById();
	CandidateList save(CandidateList candidateList);
	void delete(Long id);
	CandidateList findById(Long id);
}
