package org.mule.modules.slack.model;

import java.io.Serializable;

import org.mule.api.annotations.param.Default;
import org.mule.api.annotations.param.Optional;

public class Search implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String token;
	
	private String query;
	
	@Optional
	@Default("score")
	private String sort;

	@Optional
	@Default("desc")
	private String sortDir;
	
	@Optional
	@Default("1")
	private int highlight;
	
	@Optional
	@Default("100")
	private int count;
	
	@Optional
	@Default("2")
	private int page;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getSortDir() {
		return sortDir;
	}

	public void setSortDir(String sortDir) {
		this.sortDir = sortDir;
	}

	public int getHighlight() {
		return highlight;
	}

	public void setHighlight(int highlight) {
		this.highlight = highlight;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
	
}
