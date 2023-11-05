package com.cavm.voto.electronico.respositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cavm.voto.electronico.models.CandidateList;

public interface ICandidateListRepository extends CrudRepository<CandidateList, Long> {
	List<CandidateList> findAllByOrderById();
}
