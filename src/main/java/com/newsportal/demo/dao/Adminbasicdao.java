package com.newsportal.demo.dao;

import java.util.List;

import com.newsportal.demo.model.Adminbasicmodel;


/**
 * 
 * @author Hemamalini
 * @version 29/04/2022
 *
 */

public interface Adminbasicdao {

	public abstract List<Adminbasicmodel> getAllAdmin();

	public abstract String insertAdmin(Adminbasicmodel a);

	public abstract String deleteAdmin(Adminbasicmodel c);

}

