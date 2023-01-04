package com.example.man.demoMan.service.crud;
/*package ec.com.bancointernacional.service.crud;*/

import com.example.man.demoMan.model.crud.request.MatchRequest;
import com.example.man.demoMan.model.crud.response.GenericResponse;
import com.example.man.demoMan.model.crud.response.MatchGetAllResponse;
import com.example.man.demoMan.model.crud.response.MatchGetResponse;

/*
import javax.ejb.Local;

@Local
 */
public interface MatchService {

	GenericResponse create(MatchRequest matchRequest);

	MatchGetAllResponse getAll();

	MatchGetResponse getByName(String name);

	GenericResponse update(MatchRequest matchRequest);

	GenericResponse delete(Integer idEst);

}
