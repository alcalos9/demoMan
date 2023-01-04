package com.example.man.demoMan.service.crud;


import com.example.man.demoMan.model.crud.request.EstablecimientoCerradoRequest;
import com.example.man.demoMan.model.crud.response.EstablecimientoCerradoGetAllResponse;
import com.example.man.demoMan.model.crud.response.EstablecimientoCerradoGetResponse;
import com.example.man.demoMan.model.crud.response.GenericResponse;

/*
import javax.ejb.Local;

@Local
 */

public interface EstablecimientoCerradoService {

	public GenericResponse create(EstablecimientoCerradoRequest establecimientoCerradoRequest);

	public EstablecimientoCerradoGetAllResponse getAll();

	public EstablecimientoCerradoGetResponse getByName(String name);

	public GenericResponse update(EstablecimientoCerradoRequest establecimientoCerradoRequest);

	public GenericResponse delete(Integer idEst);
}
