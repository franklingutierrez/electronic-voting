package com.cavm.elecciones.escolares.services;

import com.cavm.elecciones.escolares.models.Institution;

public interface IInstitutionService {
	Institution save(Institution institution);
	Institution findFirstByOrderByIdAsc();
	Institution findById(Long id);
}
