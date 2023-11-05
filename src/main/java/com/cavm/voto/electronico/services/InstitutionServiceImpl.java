package com.cavm.voto.electronico.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cavm.voto.electronico.models.Institution;
import com.cavm.voto.electronico.respositories.IInstitutionRepository;

@Service
public class InstitutionServiceImpl implements IInstitutionService {
	
	@Autowired
	private IInstitutionRepository institutionRespository;
	
	@Override
	public Institution save(Institution institution) {
		return institutionRespository.save(institution);
	}

	@Override
	public Institution findFirstByOrderByIdAsc() {
		return institutionRespository.findFirstByOrderByIdAsc();
	}

	@Override
	public Institution findById(Long id) {
		return institutionRespository.findById(id).get();
	}

}
