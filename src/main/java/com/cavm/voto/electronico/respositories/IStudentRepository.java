package com.cavm.voto.electronico.respositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cavm.voto.electronico.models.Grade;
import com.cavm.voto.electronico.models.Section;
import com.cavm.voto.electronico.models.Student;

public interface IStudentRepository extends CrudRepository<Student, Long> {
	List<Student> findAllByOrderByName();
	
	@Query("SELECT s FROM Student s WHERE s.grade=:grade and s.section=:section ")
	List<Student> findAllGradeSection(@Param("grade") Grade grade, @Param("section") Section section);
	
	Student findByDni(String dni);
}
