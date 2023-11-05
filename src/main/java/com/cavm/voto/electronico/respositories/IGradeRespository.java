package com.cavm.voto.electronico.respositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cavm.voto.electronico.models.Grade;

public interface IGradeRespository extends CrudRepository<Grade, Long>{
	 List<Grade> findAllByOrderById();
}
