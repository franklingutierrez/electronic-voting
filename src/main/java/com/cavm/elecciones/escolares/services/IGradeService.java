package com.cavm.elecciones.escolares.services;

import java.util.List;

import com.cavm.elecciones.escolares.models.Grade;

public interface IGradeService {
	List<Grade> findAll();
	Grade save(Grade grade);
	void deleteById(Long id);
	//void findById(Long id);
}
