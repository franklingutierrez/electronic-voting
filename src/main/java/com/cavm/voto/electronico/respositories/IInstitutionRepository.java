package com.cavm.voto.electronico.respositories;

import org.springframework.data.repository.CrudRepository;

import com.cavm.voto.electronico.models.Institution;

public interface IInstitutionRepository extends CrudRepository<Institution, Long> {
	Institution findFirstByOrderByIdAsc();
}
