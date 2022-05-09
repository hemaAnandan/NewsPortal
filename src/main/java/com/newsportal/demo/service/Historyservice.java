package com.newsportal.demo.service;

import java.util.List;

import com.newsportal.demo.model.Historymodel;


/**
 * 
 * @author Hemamalini
 * @version 29-04-2022
 *
 */

public interface Historyservice {
	
	public abstract List<Historymodel> getAllHistory();
	
	public abstract String insertHistoryDetail(Historymodel a);
	
	public abstract Historymodel getHistoryBasedOnCurrentNews(Historymodel b);
	
	public abstract String deleteHistory(Historymodel c);
}


