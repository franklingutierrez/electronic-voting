package com.cavm.voto.electronico.services;

import java.util.List;

import com.cavm.voto.electronico.models.Grade;

public interface IGradeService {
	List<Grade> findAll();
	Grade save(Grade grade);
	void deleteById(Long id);
	//void findById(Long id);
}
