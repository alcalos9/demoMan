package com.example.man.demoMan.dao.crud;

import java.util.List;

import com.example.man.demoMan.model.crud.Match;
import com.example.man.demoMan.model.crud.response.MatchGetResponse;

/*
 
 import javax.ejb.Local;
 @Local
 
 * */
public interface MatchDao {

	Boolean create(Match match);

	List<MatchGetResponse> getAll();

	MatchGetResponse getByName(String name);
	
	Match getById(Integer name);

	Boolean update(Match match);
}
