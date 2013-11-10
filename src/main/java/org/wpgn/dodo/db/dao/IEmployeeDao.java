package org.wpgn.dodo.db.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IEmployeeDao {
	/**
	 * 获取某个月过生日员工的信息
	 * @return
	 * @throws SQLException
	 */
	public List<Map<String, Object>> getEmployeesByBirthMonth(int month)
			throws SQLException;
	
	/**
	 * 获取某个星期过生日员工的信息
	 * @return
	 * @throws SQLException
	 */
	public List<Map<String, Object>> getEmployeesByBirthWeek(int week)
			throws SQLException;
}
