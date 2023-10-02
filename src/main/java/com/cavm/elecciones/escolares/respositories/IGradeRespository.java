package com.cavm.elecciones.escolares.respositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cavm.elecciones.escolares.models.Grade;

public interface IGradeRespository extends CrudRepository<Grade, Long>{
	 List<Grade> findAllByOrderById();
}
