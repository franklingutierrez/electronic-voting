package com.cavm.voto.electronico.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cavm.voto.electronico.models.Student;
import com.cavm.voto.electronico.models.Vote;
import com.cavm.voto.electronico.respositories.IVoteRepository;

@Service
public class VoteServiceImpl implements IVoteService {
	
	@Autowired
	private IVoteRepository voteRepository;
	
	@Override
	@Transactional
	public Vote save(Vote vote) {
		return voteRepository.save(vote);
	}

	@Override
	@Transactional(readOnly = true)
	public Vote findByStudent(Student student) {
		return voteRepository.findByStudent(student);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Object[]> countVoteByList() {
		return voteRepository.countVoteByList();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Student> findStudentsWithoutVotes() {
		return voteRepository.findStudentsWithoutVotes();
	}

	@Override
	@Transactional
	public void deleteByStudent(Student student) {
		voteRepository.deleteByStudent(student);
		
	}

}
