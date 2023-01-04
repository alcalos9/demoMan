package com.example.man.demoMan.dao.crud;

import java.util.List;

import com.example.man.demoMan.model.crud.EstablecimientoCerrado;
import com.example.man.demoMan.model.crud.response.EstablecimientoCerradoGetResponse;

/*
 
 import javax.ejb.Local;
 @Local
 
 * */
public interface EstablecimientoCerradoDao {

	Boolean create(EstablecimientoCerrado establecimientoCerrado);

	List<EstablecimientoCerradoGetResponse> getAll();

	EstablecimientoCerradoGetResponse getByName(String name);
	
	EstablecimientoCerrado getById(Integer name);

	Boolean update(EstablecimientoCerrado establecimientoCerrado);
}
