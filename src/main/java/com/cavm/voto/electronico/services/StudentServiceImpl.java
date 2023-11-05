package com.cavm.voto.electronico.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cavm.voto.electronico.models.Grade;
import com.cavm.voto.electronico.models.Section;
import com.cavm.voto.electronico.models.Student;
import com.cavm.voto.electronico.respositories.IStudentRepository;

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
