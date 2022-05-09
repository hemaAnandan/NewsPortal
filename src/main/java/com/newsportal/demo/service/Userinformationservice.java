package com.newsportal.demo.service;

import java.util.List;

import com.newsportal.demo.model.Userinformationmodel;


/**
 * 
 * @author Hemamalini
 * @version 29-04-2022
 *
 */

public interface Userinformationservice {

	public abstract List<Userinformationmodel> getAllUsers();

	public abstract String insertUserData(Userinformationmodel a);

	public abstract Userinformationmodel getUserBasedOnName(Userinformationmodel b);

	public abstract String deleteUser(Userinformationmodel c);

}


