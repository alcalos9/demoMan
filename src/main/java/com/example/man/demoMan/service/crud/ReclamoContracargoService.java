package com.example.man.demoMan.service.crud;
/*package ec.com.bancointernacional.service.crud;*/

import com.example.man.demoMan.model.crud.request.ReclamoContracargoRequest;
import com.example.man.demoMan.model.crud.response.GenericResponse;
import com.example.man.demoMan.model.crud.response.ReclamoContracargoGetAllResponse;
import com.example.man.demoMan.model.crud.response.ReclamoContracargoGetResponse;

/*
import javax.ejb.Local;

@Local
 */
public interface ReclamoContracargoService {

	GenericResponse create(ReclamoContracargoRequest reclamoContracargoRequest);

	ReclamoContracargoGetAllResponse getAll();

	ReclamoContracargoGetResponse getByName(String name);

	GenericResponse update(ReclamoContracargoRequest reclamoContracargoRequest);

	GenericResponse delete(Integer idEst);

}
