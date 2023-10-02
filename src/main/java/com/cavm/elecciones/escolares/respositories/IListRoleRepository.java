package com.cavm.elecciones.escolares.respositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cavm.elecciones.escolares.models.ListRole;

public interface IListRoleRepository extends CrudRepository<ListRole, Long> {
	@Query("SELECT lr FROM ListRole lr JOIN lr.role r ORDER BY r.orderr")
	List<ListRole> orderListRoleOrder();
	
	
	@Query("SELECT lr FROM ListRole lr JOIN lr.role r JOIN lr.candidateList cl  where cl.id=:id ORDER BY r.orderr")
	List<ListRole> listRoleByList(@Param("id") Long id);
	
	@Query("SELECT lr FROM ListRole lr where lr.candidateList.id=:listId and lr.role.id=:rolId")
	ListRole ListRoleByListAndRole(@Param("listId")Long listId , @Param("rolId") Long rolId);
}
