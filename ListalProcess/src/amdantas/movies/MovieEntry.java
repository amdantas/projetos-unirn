package amdantas.movies;

import org.apache.commons.lang.StringUtils;

public class MovieEntry {

	private String title;
	
	private String year;
	
	private String description;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	public boolean isReady() {
		return !StringUtils.isEmpty(description) && !StringUtils.isEmpty(year) && !StringUtils.isEmpty(title);  
	}
}
