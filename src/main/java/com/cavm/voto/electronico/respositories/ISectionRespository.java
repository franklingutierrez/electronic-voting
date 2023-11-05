package com.cavm.voto.electronico.respositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cavm.voto.electronico.models.Section;

public interface ISectionRespository extends CrudRepository<Section, Long> {
	List<Section> findAllByOrderById();
}
