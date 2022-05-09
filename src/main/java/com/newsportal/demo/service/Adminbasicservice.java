package com.newsportal.demo.service;

import java.util.List;

import com.newsportal.demo.model.Adminbasicmodel;


/**
 * 
 * @author Hemamalini
 * @version 29/04/2022
 *
 */

public interface Adminbasicservice {
	
	public abstract List<Adminbasicmodel> getAllAdmin();
	
	public abstract String insertAdminData(Adminbasicmodel a);
	
	public abstract Adminbasicmodel getAdminBasedOnName(Adminbasicmodel b);
	
	public abstract String deleteAdmin(Adminbasicmodel c);

}

