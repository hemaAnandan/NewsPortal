package com.newsportal.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.newsportal.demo.dao.Newsfeedinformationdao;
import com.newsportal.demo.model.Newsfeedinformationmodel;
import com.newsportal.demo.service.Newsfeedinformationservice;


/**
 * 
 * @author Hemamalini
 * @version 29-04-2022
 *
 */

@Component
public class Newsfeedinformationserviceimpl implements Newsfeedinformationservice {

	@Autowired
	Newsfeedinformationdao Newsfeedinformationdaoimpl;

	@Override
	public List<Newsfeedinformationmodel> getAllNewsFeed() {
		List<Newsfeedinformationmodel> newsList = Newsfeedinformationdaoimpl.getAllNewsFeed();
		return newsList;
	}

	@Override
	public String insertNewsFeed(Newsfeedinformationmodel a) {
		return Newsfeedinformationdaoimpl.insertNewsFeed(a);
	}

	@Override
	public Newsfeedinformationmodel getNewsFeedBasedOnPopularNews(Newsfeedinformationmodel b) {
		List<Newsfeedinformationmodel> adList = Newsfeedinformationdaoimpl.getAllNewsFeed();
		Newsfeedinformationmodel model = adList.stream().filter(ad->ad.getPopularNews().equals(b.getPopularNews())).findAny().get();
		return model;
	}

	@Override
	public String deleteNewsFeed(Newsfeedinformationmodel c) {
		return Newsfeedinformationdaoimpl.deleteNewsFeed(c);
	}

}
