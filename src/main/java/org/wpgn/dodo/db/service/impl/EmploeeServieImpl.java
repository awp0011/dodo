package org.wpgn.dodo.db.service.impl;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.wpgn.dodo.db.dao.IEmployeeDao;
import org.wpgn.dodo.db.service.IEmployeeService;

@Service
public class EmploeeServieImpl implements IEmployeeService {
	private final Log logger = LogFactory.getLog(this.getClass());
	@Resource
	private IEmployeeDao iEmployeeDao;

	public List<Map<String, Object>> getEmployeesBirthInThisMonth()
			throws SQLException {
		Calendar cal = Calendar.getInstance();
		final int thisMonth = cal.get(Calendar.MONTH) + 1;
		return getEmployeesBirthByMonth(thisMonth);
	}

	public List<Map<String, Object>> getEmployeesBirthByMonth(int month)
			throws SQLException {
		if (month > 12 || month < 1) {
			logger.error("查询月份不能小于1，不能大于12");
			throw new SQLException("查询月份不能小于1，不能大于12");
		}
		return iEmployeeDao.getEmployeesByBirthMonth(month);
	}

	public void setIEmployeeDao(IEmployeeDao iEmployeeDao) {
		this.iEmployeeDao = iEmployeeDao;
	}

	public List<Map<String, Object>> getEmployeesBirthByDate(String sDate,
			String eDate) throws SQLException,ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("MMdd");
		try{
		Date startDate = sdf.parse(sDate);
		Date endDate = sdf.parse(eDate);
		if(startDate.after(endDate)){
			logger.error("参数转化字符串时出错");
			logger.error("开始日期字符串为：" +sDate+	"，结束日期字符串为"+eDate);
			throw new ParseException("参数转化字符串时出错,开始日期晚于结束日期",0);
		}
		
		}catch(ParseException pe){
			logger.error("不能转化字符串为Date类型");
			logger.error("开始日期字符串为：" +sDate+	"，结束日期字符串为"+eDate);
			throw pe;
		}
		return null;
	}

	public List<Map<String, Object>> getEmployeesBirthByWeek(int week)
			throws SQLException {
		return iEmployeeDao.getEmployeesByBirthWeek(week);
	}

}
