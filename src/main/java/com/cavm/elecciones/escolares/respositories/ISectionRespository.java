package com.cavm.elecciones.escolares.respositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cavm.elecciones.escolares.models.Section;

public interface ISectionRespository extends CrudRepository<Section, Long> {
	List<Section> findAllByOrderById();
}
