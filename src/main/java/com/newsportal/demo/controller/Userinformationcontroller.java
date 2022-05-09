package com.newsportal.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.newsportal.demo.model.Userinformationmodel;
import com.newsportal.demo.service.Userinformationservice;


/**
 * 
 * @author Hemamalini
 * @version 29-04-2022
 *
 */

@RestController
public class Userinformationcontroller {

	@Autowired
	Userinformationservice Userinformationserviceimpl;

	///URL Mapping

	@RequestMapping(value="/getuserdata", method = RequestMethod.GET)
	public List<Userinformationmodel> getAllAdmin() {
		List<Userinformationmodel> userList = Userinformationserviceimpl.getAllUsers();
		return userList;
	}

	///URL Mapping

	@RequestMapping(value = "/getUserBasedOnName" , method = RequestMethod.POST ,
			consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)

	public Userinformationmodel getUserBasedOnName(@RequestBody Userinformationmodel x) {
		Userinformationmodel s1 = Userinformationserviceimpl. getUserBasedOnName(x);
		return s1;
	}

	///URL Mapping

	@RequestMapping(value="/insertUser",method = RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public String putUserData(@RequestBody Userinformationmodel s) {
		if(s.getUserId()==0) {
			throw new IllegalArgumentException("User Id is Invalid");
		}
		String status = Userinformationserviceimpl.insertUserData(s);
		return status;
	}

	///URL Mapping

	@RequestMapping(value="/deleteUser" , method = RequestMethod.DELETE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public String deleteById(@RequestBody Userinformationmodel z) {

		if(z.getUserId()==0) {
			throw new IllegalArgumentException("User Id is Invalid");
		}
		String status = Userinformationserviceimpl.deleteUser(z);
		return status;
	}
}

