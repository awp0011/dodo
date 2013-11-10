package org.wpgn.dodo.db.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.wpgn.dodo.db.jpa.IEmpolyeeDao;
import org.wpgn.dodo.entity.TEmployee;
@Component
@Transactional
public class JpaEmployeeService {
	private IEmpolyeeDao iEmpolyeeDao;
	@Autowired
	public void setiEmpolyeeDao(IEmpolyeeDao iEmpolyeeDao) {
		this.iEmpolyeeDao = iEmpolyeeDao;
	}
	
	
	public TEmployee getEmployeeById(String id ){
		return iEmpolyeeDao.findById(id);
	}
	
	public Page<TEmployee> findByid(Pageable pageRequest){
		return iEmpolyeeDao.findAll(pageRequest);
	}
}
