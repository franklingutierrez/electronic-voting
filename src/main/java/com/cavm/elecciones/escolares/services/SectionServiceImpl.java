package com.cavm.elecciones.escolares.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cavm.elecciones.escolares.models.Section;
import com.cavm.elecciones.escolares.respositories.ISectionRespository;

@Service
public class SectionServiceImpl implements ISectionService {
	
	@Autowired
	private ISectionRespository sectionRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Section> findAllByOrderById() {
		
		return sectionRepository.findAllByOrderById();
	}

	@Override
	@Transactional
	public Section save(Section section) {
		
		return sectionRepository.save(section);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		sectionRepository.deleteById(id);
		
	}
	
	 

}
