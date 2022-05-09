package com.newsportal.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.newsportal.demo.model.Adminbasicmodel;
import com.newsportal.demo.service.Adminbasicservice;


/**
 * 
 * @author Hemamalini
 * @version 29/04/2022
 *
 */

@RestController
public class Adminbasiccontroller {

	@Autowired
	Adminbasicservice Adminbasicserviceimpl;

	/**
	 * getadmindata is used to get all admin details from server
	 * @return List
	 */

	@RequestMapping(value="/getadmindata", method = RequestMethod.GET)
	public List<Adminbasicmodel> getAllAdmin() {
		List<Adminbasicmodel> adminList = Adminbasicserviceimpl.getAllAdmin();
		return adminList;
	}

	///URL mapping

	@RequestMapping(value = "/getAdminBasedOnName" , method = RequestMethod.POST ,
			consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)

	public Adminbasicmodel getAdminBasedOnName(@RequestBody Adminbasicmodel x) {
		Adminbasicmodel s1 = Adminbasicserviceimpl. getAdminBasedOnName(x);
		return s1;
	}

	///URL mapping

	@RequestMapping(value="/insertAdmin",method = RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public String putAdminData(@RequestBody Adminbasicmodel s) {
		if(s.getAdminId()==0) {
			throw new IllegalArgumentException("Admin Id is Invalid");
		}
		String status = Adminbasicserviceimpl.insertAdminData(s);
		return status;
	}

	///URL mapping

	@RequestMapping(value="/deleteAdmin" , method = RequestMethod.DELETE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public String deleteById(@RequestBody Adminbasicmodel z) {

		if(z.getAdminId()==0) {
			throw new IllegalArgumentException("Admin Id is Invalid");
		}
		String status = Adminbasicserviceimpl.deleteAdmin(z);
		return status;
	}

}

