package com.example.man.demoMan.model.crud.response;

import java.util.List;

public class MatchGetAllResponse {

	private List<MatchGetResponse> matchs;

	/**
	 * @return the matchs
	 */
	public List<MatchGetResponse> getMatchs() {
		return matchs;
	}

	/**
	 * @param matchs the matchs to set
	 */
	public void setMatchs(List<MatchGetResponse> matchs) {
		this.matchs = matchs;
	}


	
}
