package com.cavm.elecciones.escolares.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "list_roles", uniqueConstraints = {
	    @UniqueConstraint(columnNames = { "role_id", "candidate_list_id" })
	})
public class ListRole {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, name = "name_candidate")
	@NotBlank
	private String nameCandidate;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	@NotNull
	private Role role;
	
	@ManyToOne
	@JoinColumn(name = "candidate_list_id", nullable = false)
	//@NotNull
	private CandidateList candidateList;
	private String state = "1";
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNameCandidate() {
		return nameCandidate;
	}
	public void setNameCandidate(String nameCandidate) {
		this.nameCandidate = nameCandidate;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public CandidateList getCandidateList() {
		return candidateList;
	}
	public void setCandidateList(CandidateList candidateList) {
		this.candidateList = candidateList;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
	
}
