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

import com.newsportal.demo.dao.Historydao;
import com.newsportal.demo.model.Historymodel;

/**
 * 
 * @author Hemamalini
 * @version 29-04-2022
 *
 */

@Component
public class Historydaoimpl implements Historydao{

	@Autowired
	JdbcTemplate template;

	@Override
	public List<Historymodel> getAllHistory() {
		List<Historymodel>  historyDetailList = template.query("select * from detailhistory.data", new ResultSetExtractor<List<Historymodel>>() {
			List<Historymodel> historyList = new ArrayList<>();

			@Override
			public List<Historymodel> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while(rs.next()) {
					Historymodel s = new Historymodel();
					s.setAdminId(rs.getInt("adminId"));
					s.setLoginStatus(rs.getString("loginStatus"));
					s.setCurrentNews(rs.getString("currentNews"));
					s.setFrequentNewsUpdate(rs.getString("frequentNewsUpdate"));
					s.setWorldNews(rs.getString("worldNews"));
					s.setSports(rs.getString("Sports"));
					historyList.add(s);
				}
				return historyList;
			}
		});
		return historyDetailList;
	}

	@Override
	public String insertHistoryDetail(Historymodel a) {
		String status = "History Detail inserted failed";
		String sql = "insert into detailhistory.data(adminId,loginStatus,currentNews,frequentNewsUpdate,worldNews,Sports)"
				+ " values("+a.getAdminId() +",'"+a.getLoginStatus() +"','"+a.getCurrentNews() +"','"+a.getFrequentNewsUpdate()
				+"','"+a.getWorldNews()+"','"+a.getSports()+"')";

		try {
			template.execute(sql);
			status = "History Detail inserted successfully";
		}catch(Exception e) {
			System.out.println(e);
		}

		return status;
	}

	@Override
	public String deleteHistory(Historymodel c) {
		String status = "History deleted failed";
		String sql = "delete from detailhistory.data where adminId = " +c.getAdminId();

		try {
			template.execute(sql);
			status = "History deleted successfully";
		}catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}

}

