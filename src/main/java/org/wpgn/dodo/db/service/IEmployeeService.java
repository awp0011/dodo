package org.wpgn.dodo.db.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface IEmployeeService {
	/**
	 * 获取本月生日的员工 信息
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<Map<String, Object>> getEmployeesBirthInThisMonth()
			throws SQLException;

	/**
	 * 获取指定月生日的员工信息
	 * 
	 * @param month
	 * @return
	 * @throws SQLException
	 */
	public List<Map<String, Object>> getEmployeesBirthByMonth(int month)
			throws SQLException;

	public List<Map<String, Object>> getEmployeesBirthByDate(String sDate,String eDate)
			throws SQLException,ParseException;
	
	public List<Map<String, Object>> getEmployeesBirthByWeek(int week)
			throws SQLException;
}
