package com.newsportal.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.newsportal.demo.dao.Adminbasicdao;
import com.newsportal.demo.model.Adminbasicmodel;
import com.newsportal.demo.service.Adminbasicservice;


/**
 * 
 * @author Hemamalini
 * @version 29/04/2022
 *
 */

@Component
public class Adminbasicserviceimpl implements Adminbasicservice {

	@Autowired
	Adminbasicdao Adminbasicdaoimpl;

	@Override
	public List<Adminbasicmodel> getAllAdmin() {
		List<Adminbasicmodel> adminList = Adminbasicdaoimpl.getAllAdmin();
		return adminList;
	}

	@Override
	public String insertAdminData(Adminbasicmodel a) {
		return Adminbasicdaoimpl.insertAdmin(a);
	}

	@Override
	public Adminbasicmodel getAdminBasedOnName(Adminbasicmodel b) {
		List<Adminbasicmodel> adList = Adminbasicdaoimpl.getAllAdmin();
		Adminbasicmodel model = adList.stream().filter(ad->ad.getAdminUserName().equals(b.getAdminUserName())).findAny().get();
		return model;
	}

	@Override
	public String deleteAdmin(Adminbasicmodel c) {
		return Adminbasicdaoimpl.deleteAdmin(c);
	}

}

