package com.newsportal.demo.dao;

import java.util.List;

import com.newsportal.demo.model.Userinformationmodel;


/**
 * 
 * @author Hemamalini
 * @version 29-04-2022
 *
 */

public interface Userinformationdao {

	public abstract List<Userinformationmodel> getAllUsers();

	public abstract String insertUser(Userinformationmodel a);

	public abstract String deleteUser(Userinformationmodel c);

}


