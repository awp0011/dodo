package org.wpgn.dodo.spring.mvc.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wpgn.dodo.db.service.IEmployeeService;
import org.wpgn.dodo.db.service.JpaEmployeeService;
import org.wpgn.dodo.dto.DDLObject;
import org.wpgn.dodo.dto.SimpleJsonObject;
import org.wpgn.dodo.entity.TEmployee;

@Controller
@RequestMapping("/springMVC")
public class DataServiceController extends AsbtractDataGridController<TEmployee>{

	private final Log logger = LogFactory.getLog(this.getClass());
	@Resource
	private IEmployeeService iEmployeeService;

	@Autowired
	private JpaEmployeeService jpaEmployeeService;
	
	@RequestMapping("/ajaxsimple.action")
	@ResponseBody
	public SimpleJsonObject ajaxInvokeController(
			final @RequestParam(value = "sayWords", required = true) String sayWords) {
		final SimpleJsonObject family = new SimpleJsonObject();
		family.setFather("王大胖");
		family.setMother("郭能能");
		family.setMe("多多");
		family.setSay(sayWords);
		return family;
	}

	@RequestMapping("/whoDoesbirthByMonth.action")
	@ResponseBody
	public Map<String, Object> getEmploeesBirthByMonth(
			final @RequestParam(value = "month", required = false) String month)
			throws SQLException {
		try {
			final List<Map<String, Object>> dataList;
			final Map<String,Object> dataMap = new HashMap<String, Object>();
			if (month == null) {
				dataList = new ArrayList<Map<String, Object>>();
			} else {
				if (month == "0") {
					dataList = iEmployeeService.getEmployeesBirthInThisMonth();
				} else {
					dataList = iEmployeeService
							.getEmployeesBirthByMonth(Integer.parseInt(month));
				}
				
			}
			dataMap.put("total", dataList.size()) ;
			dataMap.put("rows", dataList);
			return dataMap;
		} catch (SQLException e) {
			logger.error("调用IEmployeeService.getEmployeesBirthByMonth时，发生异常");
			logger.error("调用参数month：" + month);
			throw e;
		}

	}
	@RequestMapping("/whoDoesbirthByWeek.action")
	@ResponseBody
	public Map<String, Object> getEmploeesBirthByWeek(
			final @RequestParam(value = "week", required = true) int week
			) throws SQLException{
		final Map<String,Object> dataMap = new HashMap<String, Object>();
		final List<Map<String, Object>> dataList= iEmployeeService.getEmployeesBirthByWeek(week);
		dataMap.put("total", dataList.size()) ;
		dataMap.put("rows", dataList);
		return dataMap;
	}
	@RequestMapping("/getMonthData.action")
	@ResponseBody
	public List<DDLObject> getDDLObject() {
		final String[] month = { "  一月(Jan)", " 二月(Feb)", " 三月(Mar)",
				" 四月(Apr)", " 五月(May)", " 六月(Jun)", " 七月(Jul)", " 八月(Aug)",
				" 九月(Sep)", " 十月(Oct)", "十一月(Nov)", "十二月(Dec)" };
		final String[] id = { "1", "2", "3", "4", "5", "6", "7", "8", "9",
				"10", "11", "12" };
		final List<DDLObject> ddlData = new ArrayList<DDLObject>();

		for (int index = 0; index < id.length; index++) {
			ddlData.add(new DDLObject(id[index], month[index]));
		}
		return ddlData;
	}
	@RequestMapping("/getemployee.action")
	@ResponseBody
	public  TEmployee getEmployeeByID(
			final @RequestParam(value = "eid", required = true) String eid
			){
		TEmployee em= jpaEmployeeService.getEmployeeById(eid);
		return em;
	}
	@RequestMapping("/getdatagrid.action")
	@ResponseBody
	public Map<String, Object> getEmployeeDataGrid(
			final @RequestParam(value = "page", required = true) int page,
			final @RequestParam(value = "rows", required = true) int rows,
			final @RequestParam(value = "sort", required = true) String sort,
			final @RequestParam(value = "order", required = true) String order
			){
		final Page<TEmployee> pagedata = jpaEmployeeService.findByid(buildPageRequest(page,rows,order,sort));
		return getDataGridData(pagedata);
	}
	public void setIEmployeeService(IEmployeeService iEmployeeService) {
		this.iEmployeeService = iEmployeeService;
	}

}
