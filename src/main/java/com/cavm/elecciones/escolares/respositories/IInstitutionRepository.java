package com.cavm.elecciones.escolares.respositories;

import org.springframework.data.repository.CrudRepository;

import com.cavm.elecciones.escolares.models.Institution;

public interface IInstitutionRepository extends CrudRepository<Institution, Long> {
	Institution findFirstByOrderByIdAsc();
}
