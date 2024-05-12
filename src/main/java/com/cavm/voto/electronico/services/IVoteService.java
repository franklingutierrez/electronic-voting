package com.cavm.voto.electronico.services;


import java.util.List;

import com.cavm.voto.electronico.models.Student;
import com.cavm.voto.electronico.models.Vote;

public interface IVoteService {
	Vote save(Vote vote);
	Vote findByStudent(Student student);
	List<Object[]> countVoteByList();
	List<Student> findStudentsWithoutVotes();
	void deleteByStudent(Student student);
	void resetVotes();
}
