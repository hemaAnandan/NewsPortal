package com.newsportal.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.newsportal.demo.model.Historymodel;
import com.newsportal.demo.service.Historyservice;


/**
 * 
 * @author Hemamalini
 * @version 29-04-2022
 *
 */

@RestController
public class Historycontroller {

	@Autowired
	Historyservice Historyserviceimpl;

	///URL Mapping

	@RequestMapping(value="/getHistory", method = RequestMethod.GET)
	public List<Historymodel> getAllHistory() {
		List<Historymodel> historyList = Historyserviceimpl.getAllHistory();
		return historyList;
	}

	///URL Mapping

	@RequestMapping(value = "/getHistoryBasedOnCurrentNews" , method = RequestMethod.POST ,
			consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
	public Historymodel getHistoryBasedOnCurrentNews(@RequestBody Historymodel x) {
		Historymodel s1 = Historyserviceimpl. getHistoryBasedOnCurrentNews(x);
		return s1;
	}

	///URL Mapping

	@RequestMapping(value="/insertHistoryDetail",method = RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public String putHistoryData(@RequestBody Historymodel s) {
		if(s.getAdminId()== 0) {
			throw new IllegalArgumentException("Admin Id is Invalid");
		}
		String status = Historyserviceimpl.insertHistoryDetail(s);
		return status;
	}

	///URL Mapping

	@RequestMapping(value="/deleteHistory" , method = RequestMethod.DELETE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public String deleteByAdminId(@RequestBody Historymodel z) {

		if(z.getAdminId()== 0) {
			throw new IllegalArgumentException("Admin Id is Invalid");
		}
		String status = Historyserviceimpl.deleteHistory(z);
		return status;
	}


}

