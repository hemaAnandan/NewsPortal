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

import com.newsportal.demo.dao.Newsfeedinformationdao;
import com.newsportal.demo.model.Newsfeedinformationmodel;


/**
 * 
 * @author Hemamalini
 * @version 29-04-2022
 *
 */

@Component
public class Newsfeedinformationdaoimpl implements Newsfeedinformationdao {

	@Autowired
	JdbcTemplate template;

	@Override
	public List<Newsfeedinformationmodel> getAllNewsFeed() {
		List<Newsfeedinformationmodel>  newsDataList = template.query("select * from newsfeedinfo.data", 
				new ResultSetExtractor<List<Newsfeedinformationmodel>>() {
			List<Newsfeedinformationmodel> newsList = new ArrayList<>();

			@Override
			public List<Newsfeedinformationmodel> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while(rs.next()) {
					Newsfeedinformationmodel s = new Newsfeedinformationmodel();
					s.setAdminId(rs.getInt("adminId"));
					s.setFrequentNewsUpdates(rs.getString("FrequentNewsUpdates"));
					s.setBreakingNews(rs.getString("breakingNews"));
					s.setPopularNews(rs.getString("PopularNews"));
					s.setMostReadTopics(rs.getString("MostReadTopics"));
					s.setAutoRefresh(rs.getString("autoRefresh"));
					s.setNewspaperChoice(rs.getString("NewspaperChoice"));
					newsList.add(s);
				}
				return newsList;
			}
		});
		return newsDataList;
	}

	@Override
	public String insertNewsFeed(Newsfeedinformationmodel a) {
		String status = "News Feed inserted failed";

		String sql = "insert into newsfeedinfo.data(adminId,FrequentNewsUpdates,breakingNews,PopularNews,MostReadTopics,autoRefresh,NewspaperChoice)"
				+ " values("+a.getAdminId() +",'"+a.getFrequentNewsUpdates() +"','"+a.getBreakingNews() +"','"+a.getPopularNews()
				+"','"+a.getMostReadTopics()+"','"+a.getAutoRefresh()+"','"+a.getNewspaperChoice()+"')";

		try {
			template.execute(sql);
			status = "News Feed inserted successfully";
		}catch(Exception e) {
			System.out.println(e);
		}

		return status;
	}

	@Override
	public String deleteNewsFeed(Newsfeedinformationmodel c) {
		String status = "News Feed deleted failed";
		String sql = "delete from newsfeedinfo.data where adminId = " +c.getAdminId();

		try {
			template.execute(sql);
			status = "News Feed deleted successfully";
		}catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}
}

