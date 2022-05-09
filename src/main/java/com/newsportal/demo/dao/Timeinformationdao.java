package com.newsportal.demo.dao;

import java.util.List;

import com.newsportal.demo.model.Timeinformationmodel;


/**
 * 
 * @author Hemamalini
 * @version 29-04-2022
 *
 */

public interface Timeinformationdao {

	public abstract List<Timeinformationmodel> getAllTimeInfo();

	public abstract String insertTimeInfoDetail(Timeinformationmodel a);

	public abstract String deleteTimeInfo(Timeinformationmodel c);

}

