package com.newsportal.demo.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.newsportal.demo.dao.Timeinformationdao;
import com.newsportal.demo.model.Timeinformationmodel;


/**
 * 
 * @author Hemamalini
 * @version 29-04-2022
 *
 */

@Component
public class Timeinformationdaoimpl implements Timeinformationdao {

	@Autowired
	JdbcTemplate template;

	@Override
	public List<Timeinformationmodel> getAllTimeInfo() {
		List<Timeinformationmodel>  timeInfoList = template.query("select * from timeinfo.data", new ResultSetExtractor<List<Timeinformationmodel>>() {
			List<Timeinformationmodel> timeList = new ArrayList<>();

			@Override
			public List<Timeinformationmodel> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while(rs.next()) {
					Timeinformationmodel s = new Timeinformationmodel();
					s.setAdminId(rs.getInt("adminId"));
					s.setStoriesInLastOneDay(rs.getString("storiesInLastOneDay"));
					s.setStoriesInLastOneWeak(rs.getString("storiesInLastOneWeak"));
					s.setStoriesInLastOneMonth(rs.getString("storiesInLastOneMonth"));
					s.setDateRangeSearch(rs.getString("dateRangeSearch"));
					s.setAverageSearchingTimeLevel(rs.getString("AverageSearchingTimeLevel"));
					timeList.add(s);
				}
				return timeList;
			}
		});
		return timeInfoList;
	}

	@Override
	public String insertTimeInfoDetail(Timeinformationmodel a) {
		String status = "TimeInfo Detail inserted failed";
		String sql = "insert into timeinfo.data(adminId,storiesInLastOneDay,storiesInLastOneWeak,storiesInLastOneMonth,dateRangeSearch,AverageSearchingTimeLevel)"
				+ " values("+a.getAdminId() +",'"+a.getStoriesInLastOneDay() +"','"+a.getStoriesInLastOneWeak() +"','"+a.getStoriesInLastOneMonth()
				+"','"+a.getDateRangeSearch()+"','"+a.getAverageSearchingTimeLevel()+"')";

		try {
			template.execute(sql);
			status = "TimeInfo Detail inserted successfully";
		}catch(Exception e) {
			System.out.println(e);
		}

		return status;
	}

	@Override
	public String deleteTimeInfo(Timeinformationmodel c) {
		String status = "TimeInfo deleted failed";
		String sql = "delete from timeinfo.data where adminId = " +c.getAdminId();

		try {
			template.execute(sql);
			status = "TimeInfo deleted successfully";
		}catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}

}

