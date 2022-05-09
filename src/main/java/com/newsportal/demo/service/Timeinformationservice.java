package com.newsportal.demo.service;

import java.util.List;

import com.newsportal.demo.model.Timeinformationmodel;


/**
 * 
 * @author Hemamalini
 * @version 29-04-2022
 *
 */

public interface Timeinformationservice {
	
public abstract List<Timeinformationmodel> getAllTimeInfo();
	
	public abstract String insertTimeInfoDetail(Timeinformationmodel a);
	
	public abstract Timeinformationmodel getTimeInfoBasedstoriesInLastOneDay(Timeinformationmodel b);
	
	public abstract String deleteTimeInfo(Timeinformationmodel c);

}

