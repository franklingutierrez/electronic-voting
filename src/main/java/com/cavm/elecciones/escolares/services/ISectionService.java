package com.cavm.elecciones.escolares.services;

import java.util.List;

import com.cavm.elecciones.escolares.models.Section;

public interface ISectionService  {
	
	List<Section> findAllByOrderById();
	Section save(Section section);
	void deleteById(Long id);
}
