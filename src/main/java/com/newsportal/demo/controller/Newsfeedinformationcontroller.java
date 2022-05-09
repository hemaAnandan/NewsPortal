package com.newsportal.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.newsportal.demo.model.Newsfeedinformationmodel;
import com.newsportal.demo.service.Newsfeedinformationservice;


/**
 * 
 * @author Hemamalini
 * @version 29-04-2022
 *
 */

@RestController
public class Newsfeedinformationcontroller {

	@Autowired
	Newsfeedinformationservice Newsfeedinformationserviceimpl;
	
	///URL Mapping
	
	@RequestMapping(value="/getAllNewsFeed", method = RequestMethod.GET)
	public List<Newsfeedinformationmodel> getAllNewsFeed() {
		List<Newsfeedinformationmodel> newsList = Newsfeedinformationserviceimpl.getAllNewsFeed();
		return newsList;
	}
	
	///URL Mapping
	
	@RequestMapping(value = "/getNewsFeedBasedOnPopularNews" , method = RequestMethod.POST ,
			consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)

	public Newsfeedinformationmodel getNewsFeedBasedOnPopularNews(@RequestBody Newsfeedinformationmodel x) {
		Newsfeedinformationmodel s1 = Newsfeedinformationserviceimpl. getNewsFeedBasedOnPopularNews(x);
		return s1;
	}
	
	///URL Mapping

	@RequestMapping(value="/insertNewsFeed",method = RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public String putNewsFeedData(@RequestBody Newsfeedinformationmodel s) {
		if(s.getAdminId()== 0) {
			throw new IllegalArgumentException("Admin Id is Invalid");
		}
		String status = Newsfeedinformationserviceimpl.insertNewsFeed(s);
		return status;
	}
	
	///URL Mapping

	@RequestMapping(value="/deleteNewsFeed" , method = RequestMethod.DELETE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public String deleteByAdminId(@RequestBody Newsfeedinformationmodel z) {

		if(z.getAdminId()== 0) {
			throw new IllegalArgumentException("Admin Id is Invalid");
		}
		String status = Newsfeedinformationserviceimpl.deleteNewsFeed(z);
		return status;
	}
}

