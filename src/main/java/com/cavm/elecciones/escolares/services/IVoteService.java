package com.cavm.elecciones.escolares.services;


import java.util.List;

import com.cavm.elecciones.escolares.models.Student;
import com.cavm.elecciones.escolares.models.Vote;

public interface IVoteService {
	Vote save(Vote vote);
	Vote findByStudent(Student student);
	List<Object[]> countVoteByList();
}
