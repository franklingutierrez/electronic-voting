package com.cavm.voto.electronico.models;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "votes")
public class Vote {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	private Student student;
	
	@ManyToOne
	private CandidateList candidateList;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	@PrePersist
	public void fecha() {
		Date currentDate = new Date();
		this.date = currentDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public CandidateList getCandidateList() {
		return candidateList;
	}

	public void setCandiateList(CandidateList candidateList) {
		this.candidateList = candidateList;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
