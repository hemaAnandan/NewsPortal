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

import com.newsportal.demo.dao.Userinformationdao;
import com.newsportal.demo.model.Userinformationmodel;


/**
 * 
 * @author Hemamalini
 * @version 29-04-2022
 *
 */

@Component
public class Userinformationdaoimpl implements Userinformationdao {

	@Autowired
	JdbcTemplate template;

	@Override
	public List<Userinformationmodel> getAllUsers() {
		List<Userinformationmodel>  userDataList = template.query("select * from Userinformation.data", 
				new ResultSetExtractor<List<Userinformationmodel>>() {
			List<Userinformationmodel> userList = new ArrayList<>();

			@Override
			public List<Userinformationmodel> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while(rs.next()) {
					Userinformationmodel s = new Userinformationmodel();
					s.setUserId(rs.getInt("userId"));
					s.setUserName(rs.getString("userName"));
					s.setUserEmail(rs.getString("userEmail"));
					s.setPassword(rs.getString("userpassword"));
					s.setLanguageChoice(rs.getString("languageChoice"));
					userList.add(s);
				}
				return userList;
			}
		});
		return userDataList;
	}

	@Override
	public String insertUser(Userinformationmodel a) {
		String status = "Data inserted failed";

		String sql = "insert into Userinformation.data(userId,userName,userEmail,userpassword,languageChoice)"
				+ " values("+a.getUserId()+",'"+a.getUserName() +"','"+a.getUserEmail()
				+"','"+a.getPassword()+"','"+a.getLanguageChoice()+"')";

		try {
			template.execute(sql);
			status = "Data inserted successfully";
		}catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}

	@Override
	public String deleteUser(Userinformationmodel c) {
		String status = "UserData deleted failed";
		String sql = "delete from Userinformation.data where userId = " +c.getUserId();

		try {
			template.execute(sql);
			status = "UserData deleted successfully";
		}catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}

}


