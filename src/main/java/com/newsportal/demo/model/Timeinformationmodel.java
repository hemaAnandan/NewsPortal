package com.newsportal.demo.model;


/**
 * 
 * @author Hemamalini
 *
 */

public class Timeinformationmodel {

	int adminId;
	String storiesInLastOneDay;
	String storiesInLastOneWeak;
	String storiesInLastOneMonth;
	String dateRangeSearch;
	String averageSearchingTimeLevel;

	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getStoriesInLastOneDay() {
		return storiesInLastOneDay;
	}
	public void setStoriesInLastOneDay(String storiesInLastOneDay) {
		this.storiesInLastOneDay = storiesInLastOneDay;
	}
	public String getStoriesInLastOneWeak() {
		return storiesInLastOneWeak;
	}
	public void setStoriesInLastOneWeak(String storiesInLastOneWeak) {
		this.storiesInLastOneWeak = storiesInLastOneWeak;
	}
	public String getStoriesInLastOneMonth() {
		return storiesInLastOneMonth;
	}
	public void setStoriesInLastOneMonth(String storiesInLastOneMonth) {
		this.storiesInLastOneMonth = storiesInLastOneMonth;
	}
	public String getDateRangeSearch() {
		return dateRangeSearch;
	}
	public void setDateRangeSearch(String dateRangeSearch) {
		this.dateRangeSearch = dateRangeSearch;
	}
	public String getAverageSearchingTimeLevel() {
		return averageSearchingTimeLevel;
	}
	public void setAverageSearchingTimeLevel(String averageSearchingTimeLevel) {
		this.averageSearchingTimeLevel = averageSearchingTimeLevel;
	}


}

