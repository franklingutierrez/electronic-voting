package com.cavm.voto.electronico.services;

import com.cavm.voto.electronico.models.Institution;

public interface IInstitutionService {
	Institution save(Institution institution);
	Institution findFirstByOrderByIdAsc();
	Institution findById(Long id);
}
