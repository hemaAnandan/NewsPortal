package com.newsportal.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.newsportal.demo.dao.Userinformationdao;
import com.newsportal.demo.model.Userinformationmodel;
import com.newsportal.demo.service.Userinformationservice;


/**
 * 
 * @author Hemamalini
 * @version 29-04-2022
 *
 */

@Component
public class Userinformationserviceimpl implements Userinformationservice {

	@Autowired
	Userinformationdao Userinformationdaoimpl;

	@Override
	public List<Userinformationmodel> getAllUsers() {
		List<Userinformationmodel> userList = Userinformationdaoimpl.getAllUsers();
		return userList;
	}

	@Override
	public String insertUserData(Userinformationmodel a) {
		return Userinformationdaoimpl.insertUser(a);
	}

	@Override
	public Userinformationmodel getUserBasedOnName(Userinformationmodel b) {
		List<Userinformationmodel> usList = Userinformationdaoimpl.getAllUsers();
		Userinformationmodel model = usList.stream().filter(us->us.getUserName().equals(b.getUserName())).findAny().get();
		return model;
	}

	@Override
	public String deleteUser(Userinformationmodel c) {
		return Userinformationdaoimpl.deleteUser(c);
	}

}


