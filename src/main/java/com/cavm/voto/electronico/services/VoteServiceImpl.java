package com.cavm.voto.electronico.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cavm.voto.electronico.models.Student;
import com.cavm.voto.electronico.models.Vote;
import com.cavm.voto.electronico.respositories.IVoteRepository;

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

	@Override
	public List<Student> findStudentsWithoutVotes() {
		return voteRepository.findStudentsWithoutVotes();
	}

}
