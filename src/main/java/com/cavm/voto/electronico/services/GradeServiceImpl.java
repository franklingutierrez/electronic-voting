package com.cavm.voto.electronico.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cavm.voto.electronico.models.Grade;
import com.cavm.voto.electronico.respositories.IGradeRespository;

@Service
public class GradeServiceImpl implements IGradeService{
	
	@Autowired
	IGradeRespository gradeRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Grade> findAll() {
		return (List<Grade>) gradeRepository.findAllByOrderById();
	}

	@Override
	@Transactional
	public Grade save(Grade grade) {
		return gradeRepository.save(grade);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		gradeRepository.deleteById(id);
		
	}




}
