package com.cavm.voto.electronico.services;

import java.util.List;

import com.cavm.voto.electronico.models.Grade;
import com.cavm.voto.electronico.models.Section;
import com.cavm.voto.electronico.models.Student;

public interface IStudentService {
	List<Student> findAllByOrderByName();
	List<Student> findAllGradeSection(Grade grade, Section section);
	Student save(Student student);
	Student findById(Long id);
	Student findByDni(String dni);
	void deleteById(Long id);
}
