package com.cavm.elecciones.escolares.respositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cavm.elecciones.escolares.models.Student;
import com.cavm.elecciones.escolares.models.Vote;

public interface IVoteRepository extends CrudRepository<Vote, Long> {
	
	Vote findByStudent(Student student);
	
	@Query("SELECT l.name,l.color, COUNT(v.candidateList) FROM Vote v  JOIN v.candidateList l GROUP BY v.candidateList")
	List<Object[]> countVoteByList();
}
