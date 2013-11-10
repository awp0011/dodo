package org.wpgn.dodo.spring.mvc.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

public class AsbtractDataGridController<T> {

	protected Map<String,Object> getDataGridData(Page<T> pageData) {
		final Map<String,Object> dataGridData = new HashMap<String, Object>();
		dataGridData.put("total", pageData.getTotalElements());
		dataGridData.put("rows",pageData.getContent());
		return dataGridData;
	}
	 /**
     * 创建分页请求.
     */
	protected PageRequest buildPageRequest(int pageNumber, int pagzSize, String sortType,String sortField) {
        Sort sort = null;
        if ("desc".equals(sortType.toLowerCase())) {
            sort = new Sort(Direction.DESC, sortField);
        } else if ("title".equals(sortType)) {
            sort = new Sort(Direction.ASC, sortField);
        }
        return new PageRequest(pageNumber - 1, pagzSize, sort);
    }
}
