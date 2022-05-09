package com.newsportal.demo.dao;

import java.util.List;

import com.newsportal.demo.model.Historymodel;


/**
 * 
 * @author Hemamalini
 * @version 29-04-2022
 *
 */

public interface Historydao {

	public abstract List<Historymodel> getAllHistory();

	public abstract String insertHistoryDetail(Historymodel a);

	public abstract String deleteHistory(Historymodel c);

}


