package com.example.man.demoMan.dao.crud;

import java.util.List;

import com.example.man.demoMan.model.crud.ReclamoContracargo;
import com.example.man.demoMan.model.crud.response.ReclamoContracargoGetResponse;

/*
 
 import javax.ejb.Local;
 @Local
 
 * */
public interface ReclamoContracargoDao {

	Boolean create(ReclamoContracargo reclamoContracargo);

	List<ReclamoContracargoGetResponse> getAll();

	ReclamoContracargoGetResponse getByName(String name);
	
	ReclamoContracargo getById(Integer name);

	Boolean update(ReclamoContracargo reclamoContracargo);
}
