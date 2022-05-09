package com.newsportal.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.newsportal.demo.model.Timeinformationmodel;
import com.newsportal.demo.service.Timeinformationservice;


/**
 * 
 * @author Hemamalini
 * @version 29-04-2022
 *
 */

@RestController
public class Timeinformationcontroller {

	@Autowired
	Timeinformationservice Timeinformationserviceimpl;

	///URL Mapping

	@RequestMapping(value="/getTimeInfo", method = RequestMethod.GET)
	public List<Timeinformationmodel> getAllTimeInfo() {
		List<Timeinformationmodel> timeList = Timeinformationserviceimpl.getAllTimeInfo();
		return timeList;
	}

	///URL Mapping

	@RequestMapping(value = "/getTimeInfoBasedstoriesInLastOneDay" , method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
	public Timeinformationmodel getTimeInfoBasedstoriesInLastOneDay(@RequestBody Timeinformationmodel x) {
		Timeinformationmodel s1 = Timeinformationserviceimpl. getTimeInfoBasedstoriesInLastOneDay(x);
		return s1;
	}

	///URL Mapping

	@RequestMapping(value="/insertTimeInfoDetail",method = RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public String putTimeInfoData(@RequestBody Timeinformationmodel s) {
		if(s.getAdminId()== 0) {
			throw new IllegalArgumentException("Admin Id is Invalid");
		}
		String status = Timeinformationserviceimpl.insertTimeInfoDetail(s);
		return status;
	}

	///URL Mapping

	@RequestMapping(value="/deleteTimeInfo" , method = RequestMethod.DELETE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public String deleteByAdminId(@RequestBody Timeinformationmodel z) {

		if(z.getAdminId()== 0) {
			throw new IllegalArgumentException("Admin Id is Invalid");
		}
		String status = Timeinformationserviceimpl.deleteTimeInfo(z);
		return status;
	}


}

