package com.cavm.elecciones.escolares.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "candidate_lists")
public class CandidateList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(nullable = false)
	private String name;
	

	@Column(name = "img_candidate", nullable = false)
	private String imgCandidate;
	

	@Column(nullable = false)
	private String logo;
	
	private String color;
	
	/*@OneToMany(mappedBy = "lista")
    private List<Vote> votes;*/
	
	@Column(nullable = false)
	private String state = "1";
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImgCandidate() {
		return imgCandidate;
	}
	public void setImgCandidate(String imgCandidate) {
		this.imgCandidate = imgCandidate;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
}
