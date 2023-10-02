package com.cavm.elecciones.escolares.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cavm.elecciones.escolares.models.Grade;
import com.cavm.elecciones.escolares.models.Section;
import com.cavm.elecciones.escolares.models.Student;
import com.cavm.elecciones.escolares.respositories.IStudentRepository;

@Service
public class StudentServiceImpl implements IStudentService {
	@Autowired
	private IStudentRepository studentRepository;
	
	@Override
	public List<Student> findAllByOrderByName() {
		return studentRepository.findAllByOrderByName();
	}

	@Override
	public Student save(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public void deleteById(Long id) {
		studentRepository.deleteById(id);
		
	}

	@Override
	public List<Student> findAllGradeSection(Grade grade, Section section) {
		return studentRepository.findAllGradeSection(grade, section);
	}

	@Override
	public Student findById(Long id) {
		return studentRepository.findById(id).get();
	}

	@Override
	public Student findByDni(String dni) {
		return studentRepository.findByDni(dni);
	}

}
