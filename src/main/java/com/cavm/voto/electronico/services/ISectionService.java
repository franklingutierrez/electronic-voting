package com.cavm.voto.electronico.services;

import java.util.List;

import com.cavm.voto.electronico.models.Section;

public interface ISectionService  {
	
	List<Section> findAllByOrderById();
	Section save(Section section);
	void deleteById(Long id);
}
