package com.cavm.voto.electronico.respositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cavm.voto.electronico.models.Student;
import com.cavm.voto.electronico.models.Vote;

public interface IVoteRepository extends CrudRepository<Vote, Long> {
	
	Vote findByStudent(Student student);
	
	@Query("SELECT l.name,l.color, COUNT(v.candidateList) FROM Vote v  JOIN v.candidateList l GROUP BY v.candidateList")
	List<Object[]> countVoteByList();
	
	@Query("SELECT s FROM Vote v  Right JOIN v.student s WHERE s IS NULL")
    List<Student> findStudentsWithoutVotes();
	
	void deleteByStudent(Student student);
	

}
