package com.example.man.demoMan.service.crud.impl;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.man.demoMan.dao.crud.MatchDao;
import com.example.man.demoMan.model.crud.Match;
import com.example.man.demoMan.model.crud.request.MatchRequest;
import com.example.man.demoMan.model.crud.response.GenericResponse;
import com.example.man.demoMan.model.crud.response.MatchGetAllResponse;
import com.example.man.demoMan.model.crud.response.MatchGetResponse;
import com.example.man.demoMan.service.crud.MatchService;

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
public class MatchServiceImpl implements MatchService {

	/*@EJB*/
	@Autowired
	private MatchDao dao;
	
	@Override
	public GenericResponse create(MatchRequest matchRequest) {
		GenericResponse response = new GenericResponse();
		
		Match match = new Match();
		match = validate(matchRequest, 1);

		if (match != null) {
			
			Boolean res= dao.create(match);
			
			if (res) {
				
				response.setMessageId(200);
				response.setMessageDescr("Match creado exitosamente");
			} else {
				
				response.setMessageId(402);
				response.setMessageDescr("Error, no se pudo crear el match");
			}

		} else {

			response.setMessageId(401);
			response.setMessageDescr("Error en la validación de datos");

		}

		return response;
	}

	@Override
	public MatchGetAllResponse getAll() {
//		MatchGetAllResponse response = new MatchGetAllResponse();
//		MatchGetResponse res = new MatchGetResponse();
//		List<MatchGetResponse> list = new ArrayList<MatchGetResponse>();
//		
//		res.setMatEstado("estado");
//		res.setMatId(1);
//		res.setMatNomComercio("nombre comercio");
//		res.setMatReprLeg("representante legal");
//		res.setMatRuc("ruc");
//		res.setMatUsuario("usuario");	
		
		try {

			MatchGetAllResponse res = new MatchGetAllResponse();

			List<MatchGetResponse> list = new ArrayList<MatchGetResponse>();
			//list.add(response);
			list = dao.getAll();
			
			if (list != null) {
				res.setMatchs(list);
				return res;

			} else {
				System.out.println("Error al obtener match");
				return null;

			}

		} catch (Exception e) {
			System.out.println("Error al obtener match");
			return null;
			
		}
	}

	@Override
	public MatchGetResponse getByName(String name) {
		MatchGetResponse response = new MatchGetResponse();
//		reponse.setMatEstado("estado");
//		reponse.setMatId(1);
//		reponse.setMatNomComercio("nombre comercio");
//		reponse.setMatReprLeg("representante legal");
//		reponse.setMatRuc("ruc");
//		reponse.setMatUsuario("usuario");
		
		try {
			
			response = dao.getByName(name);
			
			if (response != null) {
				return response;

			} else {
				System.out.println("Error al obtener el match");
				return null;

			}

		} catch (Exception e) {

			System.out.println("Error al obtener el match");
			return null;
		}
		
	}

	@Override
	public GenericResponse update(MatchRequest matchRequest) {
		GenericResponse response = new GenericResponse();
		
		Match match = new Match();
		match = validate(matchRequest, 2);

		if (match != null) {
			
			Boolean res= dao.update(match);
			
			if (res) {
				
				response.setMessageId(200);
				response.setMessageDescr("Match creado exitosamente");
			} else {
				
				response.setMessageId(402);
				response.setMessageDescr("Error, no se pudo crear el match");
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
		
		Match match = dao.getById(idEst);
		
		if (match != null) {
			
			match.setMatEstado("X");
			match.setMatFecAct(date);
			
			Boolean res= dao.update(match);
			
			if (res) {
				
				response.setMessageId(200);
				response.setMessageDescr("Match eliminado exitosamente");
			} else {
				
				response.setMessageId(402);
				response.setMessageDescr("Error al eliminar el match");
			}

		} else {

			response.setMessageId(401);
			response.setMessageDescr("Error en la validación de datos");

		}
		
		return response;
	}
	
	private Match validate(MatchRequest matchRequest, int option) {
		
		Match match = new Match();

		try {
			Date date = Date.from(Instant.now());

			match.setMatNomComercio(getUser());
			match.setMatRuc(getUser());
			match.setMatReprLeg(getUser());
			match.setMatUsuario(getUser());
			
			if (option == 1) {
				//CREA
				match.setMatEstado("A");
				match.setMatFecCrea(date);
			
			} else {
				if (option == 2) {
					//Actualiza
					match.setMatFecAct(date);
				} else {
					match.setMatEstado("X");
					match.setMatFecAct(date);
				}
			}

			return match;

		} catch (Exception e) {
			System.out.println("Error al obtener un dato para crear match");
			return null;
		}

	}

	private String getUser() {
		// TODO Obgener el usuario actual
		return null;
	}

}
