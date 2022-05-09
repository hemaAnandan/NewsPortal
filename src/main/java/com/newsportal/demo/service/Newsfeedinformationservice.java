package com.newsportal.demo.service;

import java.util.List;

import com.newsportal.demo.model.Newsfeedinformationmodel;


/**
 * 
 * @author Hemamalini
 * @version 29-04-2022
 *
 */

public interface Newsfeedinformationservice {
	
	public abstract List<Newsfeedinformationmodel> getAllNewsFeed();
	
	public abstract String insertNewsFeed(Newsfeedinformationmodel a);
	
	public abstract Newsfeedinformationmodel getNewsFeedBasedOnPopularNews(Newsfeedinformationmodel b);
	
	public abstract String deleteNewsFeed(Newsfeedinformationmodel c);

	


}
