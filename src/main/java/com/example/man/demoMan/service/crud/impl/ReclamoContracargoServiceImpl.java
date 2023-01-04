package com.example.man.demoMan.service.crud.impl;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.man.demoMan.dao.crud.ReclamoContracargoDao;
import com.example.man.demoMan.model.crud.ReclamoContracargo;
import com.example.man.demoMan.model.crud.request.ReclamoContracargoRequest;
import com.example.man.demoMan.model.crud.response.GenericResponse;
import com.example.man.demoMan.model.crud.response.ReclamoContracargoGetAllResponse;
import com.example.man.demoMan.model.crud.response.ReclamoContracargoGetResponse;
import com.example.man.demoMan.service.crud.ReclamoContracargoService;

/*
import java.net.MalformedURLException;
import java.net.URL;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;


@Stateless
 */

@Service
public class ReclamoContracargoServiceImpl implements ReclamoContracargoService {
	
	/*@EJB*/
	@Autowired
	private ReclamoContracargoDao dao;

	@Override
	public GenericResponse create(ReclamoContracargoRequest reclamoContracargoRequest) {
		GenericResponse response = new GenericResponse();
		ReclamoContracargo reclamoContracargo = new ReclamoContracargo();
		reclamoContracargo = validate(reclamoContracargoRequest, 1);

		if (reclamoContracargo != null) {
			
			Boolean res= dao.create(reclamoContracargo);
			
			if (res) {
				
				response.setMessageId(200);
				response.setMessageDescr("Reclamo contracargo creado exitosamente");
			} else {
				
				response.setMessageId(402);
				response.setMessageDescr("Error, no se pudo crear el reclamo contracargo");
			}

		} else {

			response.setMessageId(401);
			response.setMessageDescr("Error en la validación de datos");

		}

		return response;
	}

	@Override
	public ReclamoContracargoGetAllResponse getAll() {
//		ReclamoContracargoGetAllResponse response = new ReclamoContracargoGetAllResponse();
//		List<ReclamoContracargoGetResponse> list = new ArrayList<ReclamoContracargoGetResponse>();
//		ReclamoContracargoGetResponse res = new ReclamoContracargoGetResponse();
//		
//		res.setRecCodPais("cod pais");
//		res.setRecEstado("estado");
//		res.setRecId(1);
//		res.setRecNomComercio("nombre comercio");
//		res.setRecUsuario("usuario");
//		
//		list.add(res);
//		
//		response.setReclamos(list);
		
		try {

			ReclamoContracargoGetAllResponse res = new ReclamoContracargoGetAllResponse();

			List<ReclamoContracargoGetResponse> list = new ArrayList<ReclamoContracargoGetResponse>();
			//list.add(response);
			list = dao.getAll();
			
			if (list != null) {
				res.setReclamos(list);
				return res;

			} else {
				System.out.println("Error al obtener los reclamos");
				return null;

			}

		} catch (Exception e) {
			System.out.println("Error al obtener los reclamos");
			return null;
			
		}
	}

	@Override
	public ReclamoContracargoGetResponse getByName(String name) {
		ReclamoContracargoGetResponse response = new ReclamoContracargoGetResponse();
//		response.setRecCodPais("cod pais");
//		response.setRecEstado("estado");
//		response.setRecId(1);
//		response.setRecNomComercio("nombre comercio");
//		response.setRecUsuario("usuario");
		
		try {
			
			response = dao.getByName(name);
			
			if (response != null) {
				return response;

			} else {
				System.out.println("Error al obtener el reclamo");
				return null;

			}

		} catch (Exception e) {

			System.out.println("Error al obtener el reclamo");
			return null;
		}
	}

	@Override
	public GenericResponse update(ReclamoContracargoRequest reclamoContracargoRequest) {
		GenericResponse response = new GenericResponse();
		ReclamoContracargo reclamoContracargo = new ReclamoContracargo();
		reclamoContracargo = validate(reclamoContracargoRequest, 2);

		if (reclamoContracargo != null) {
			
			Boolean res= dao.update(reclamoContracargo);
			
			if (res) {
				
				response.setMessageId(200);
				response.setMessageDescr("Reclamo contracargo actualizado exitosamente");
			} else {
				
				response.setMessageId(402);
				response.setMessageDescr("Error, no se pudo actualizar el reclamo contracargo");
			}

		} else {

			response.setMessageId(401);
			response.setMessageDescr("Error en la validación de datos");

		}

		return response;
	}

	@Override
	public GenericResponse delete(Integer idEst) {
		GenericResponse response = new GenericResponse();
		Date date = Date.from(Instant.now());
		ReclamoContracargo reclamoContracargo = dao.getById(idEst);

		if (reclamoContracargo != null) {
			
			reclamoContracargo.setRecEstado("X");
			reclamoContracargo.setRecFecAct(date);
			Boolean res= dao.update(reclamoContracargo);
			
			if (res) {
				
				response.setMessageId(200);
				response.setMessageDescr("Reclamo contracargo eliminado exitosamente");
			} else {
				
				response.setMessageId(402);
				response.setMessageDescr("Error, no se pudo eliminar el reclamo contracargo");
			}

		} else {

			response.setMessageId(401);
			response.setMessageDescr("Error en la validación de datos");

		}

		return response;
	}
	
	private ReclamoContracargo validate(ReclamoContracargoRequest reclamoContracargoRequest, int i) {
		// TODO Auto-generated method stub
		return null;
	}

}
