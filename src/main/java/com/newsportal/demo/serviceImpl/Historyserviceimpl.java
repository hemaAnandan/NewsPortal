package com.newsportal.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.newsportal.demo.dao.Historydao;
import com.newsportal.demo.model.Historymodel;
import com.newsportal.demo.service.Historyservice;


/**
 * 
 * @author Hemamalini
 * @version 29-04-2022
 *
 */

@Component
public class Historyserviceimpl implements Historyservice {

	@Autowired
	Historydao Historydaoimpl;

	@Override
	public List<Historymodel> getAllHistory() {
		List<Historymodel> historyList = Historydaoimpl.getAllHistory();
		return historyList;
	}

	@Override
	public String insertHistoryDetail(Historymodel a) {
		return Historydaoimpl.insertHistoryDetail(a);
	}

	@Override
	public Historymodel getHistoryBasedOnCurrentNews(Historymodel b) {
		List<Historymodel> hiList = Historydaoimpl.getAllHistory();
		Historymodel model = hiList.stream().filter(ad->ad.getCurrentNews().equals(b.getCurrentNews())).findAny().get();
		return model;
	}

	@Override
	public String deleteHistory(Historymodel c) {
		return Historydaoimpl.deleteHistory(c);
	}

}

