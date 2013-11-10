package org.wpgn.dodo.db.jpa;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.wpgn.dodo.entity.TEmployee;


public interface IEmpolyeeDao extends
		PagingAndSortingRepository<TEmployee, String>,JpaSpecificationExecutor<TEmployee> {
	public TEmployee findById(String id);
}
