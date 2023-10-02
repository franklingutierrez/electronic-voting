package com.cavm.elecciones.escolares.services;

import java.util.List;

import com.cavm.elecciones.escolares.models.Grade;
import com.cavm.elecciones.escolares.models.Section;
import com.cavm.elecciones.escolares.models.Student;

public interface IStudentService {
	List<Student> findAllByOrderByName();
	List<Student> findAllGradeSection(Grade grade, Section section);
	Student save(Student student);
	Student findById(Long id);
	Student findByDni(String dni);
	void deleteById(Long id);
}
