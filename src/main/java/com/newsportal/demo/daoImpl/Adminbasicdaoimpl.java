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

import com.newsportal.demo.dao.Adminbasicdao;
import com.newsportal.demo.model.Adminbasicmodel;


/**
 * 
 * @author Hemamalini
 * @version 29/04/2022
 *
 */

@Component
public class Adminbasicdaoimpl implements Adminbasicdao {

	@Autowired
	JdbcTemplate template;


	@Override
	public List<Adminbasicmodel> getAllAdmin() {
		List<Adminbasicmodel>  adminDataList = template.query("select * from Adminbasic.data", new ResultSetExtractor<List<Adminbasicmodel>>() {
			List<Adminbasicmodel> adminList = new ArrayList<>();

			@Override
			public List<Adminbasicmodel> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while(rs.next()) {
					Adminbasicmodel s = new Adminbasicmodel();
					s.setAdminId(rs.getInt("adminId"));
					s.setAdminUserName(rs.getString("adminUserName"));
					s.setAdminPassword(rs.getString("adminPassword"));
					s.setCreateStatus(rs.getString("createStatus"));
					s.setUpdateStatus(rs.getString("updateStatus"));
					adminList.add(s);
				}
				return adminList;
			}
		});
		return adminDataList;
	}

	@Override
	public String insertAdmin(Adminbasicmodel a) {
		String status = "Data inserted failed";

		String sql = "insert into Adminbasic.data(adminId,adminUserName,adminPassword,createStatus,updateStatus)"
				+ " values("+a.getAdminId()+",'"+a.getAdminUserName() +"','"+a.getAdminPassword()
				+"','"+a.getCreateStatus()+"','"+a.getUpdateStatus()+"')";

		try {
			template.execute(sql);
			status = "Data inserted successfully";
		}catch(Exception e) {
			System.out.println(e);
		}

		return status;
	}

	@Override
	public String deleteAdmin(Adminbasicmodel c) {
		String status = "Data deleted failed";
		String sql = "delete from Adminbasic.data where adminId = " +c.getAdminId();

		try {
			template.execute(sql);
			status = "Data deleted successfully";
		}catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}

}

