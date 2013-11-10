package org.wpgn.dodo.db.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.wpgn.dodo.db.dao.IEmployeeDao;
@Repository
public class EmployeeDaoImpl implements IEmployeeDao {
	 @Autowired
     private DataSource dataSource;
     @Autowired
     private JdbcTemplate jdbcTemplate;
     private String mysqlSqlScriptMonth ;
     private String mysqlSqlScriptWeek ;
	public List<Map<String, Object>> getEmployeesByBirthMonth(int month)
			throws SQLException {
		
		return  jdbcTemplate.queryForList(mysqlSqlScriptMonth,month );
	}
	public List<Map<String, Object>> getEmployeesByBirthWeek(int week)
			throws SQLException {
		return  jdbcTemplate.queryForList(mysqlSqlScriptWeek,week );
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void setMysqlSqlScriptMonth(String mysqlSqlScript) {
		this.mysqlSqlScriptMonth = mysqlSqlScript;
	}

	
	public void setMysqlSqlScriptWeek(String mysqlSqlScriptWeek) {
		this.mysqlSqlScriptWeek = mysqlSqlScriptWeek;
	}

}
