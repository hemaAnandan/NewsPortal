package com.newsportal.demo.dao;

import java.util.List;

import com.newsportal.demo.model.Newsfeedinformationmodel;

public interface Newsfeedinformationdao {
	
	public abstract List<Newsfeedinformationmodel> getAllNewsFeed();

	public abstract String insertNewsFeed(Newsfeedinformationmodel a);
	
	public abstract String deleteNewsFeed(Newsfeedinformationmodel c);

	
}
