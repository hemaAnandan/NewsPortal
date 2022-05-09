package com.newsportal.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.newsportal.demo.dao.Timeinformationdao;
import com.newsportal.demo.model.Timeinformationmodel;
import com.newsportal.demo.service.Timeinformationservice;

/**
 * 
 * @author Hemamalini
 * @version 29-04-2022
 *
 */

@Component
public class Timeinformationserviceimpl implements Timeinformationservice {
	
	@Autowired
	Timeinformationdao Timeinformationdaoimpl;

	@Override
	public List<Timeinformationmodel> getAllTimeInfo() {
		List<Timeinformationmodel> timeList = Timeinformationdaoimpl.getAllTimeInfo();
		return timeList;
	}

	@Override
	public String insertTimeInfoDetail(Timeinformationmodel a) {
		return Timeinformationdaoimpl.insertTimeInfoDetail(a);
	}

	@Override
	public Timeinformationmodel getTimeInfoBasedstoriesInLastOneDay(Timeinformationmodel b) {
		List<Timeinformationmodel> tiList = Timeinformationdaoimpl.getAllTimeInfo();
		Timeinformationmodel model = tiList.stream().filter(ad->ad.getStoriesInLastOneDay().equals(b.getStoriesInLastOneDay())).findAny().get();
		return model;
	}

	@Override
	public String deleteTimeInfo(Timeinformationmodel c) {
		return Timeinformationdaoimpl.deleteTimeInfo(c);
	}

}

