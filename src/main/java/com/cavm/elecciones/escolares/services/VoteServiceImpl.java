package com.cavm.elecciones.escolares.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cavm.elecciones.escolares.models.Student;
import com.cavm.elecciones.escolares.models.Vote;
import com.cavm.elecciones.escolares.respositories.IVoteRepository;

@Service
public class VoteServiceImpl implements IVoteService {
	
	@Autowired
	private IVoteRepository voteRepository;
	
	@Override
	public Vote save(Vote vote) {
		return voteRepository.save(vote);
	}

	@Override
	public Vote findByStudent(Student student) {
		return voteRepository.findByStudent(student);
	}

	@Override
	public List<Object[]> countVoteByList() {
		return voteRepository.countVoteByList();
	}

}
