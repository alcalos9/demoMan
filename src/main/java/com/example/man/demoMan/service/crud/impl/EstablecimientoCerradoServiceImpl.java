package com.example.man.demoMan.service.crud.impl;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.man.demoMan.dao.crud.EstablecimientoCerradoDao;
import com.example.man.demoMan.model.crud.EstablecimientoCerrado;
import com.example.man.demoMan.model.crud.request.EstablecimientoCerradoRequest;
import com.example.man.demoMan.model.crud.response.EstablecimientoCerradoGetAllResponse;
import com.example.man.demoMan.model.crud.response.EstablecimientoCerradoGetResponse;
import com.example.man.demoMan.model.crud.response.GenericResponse;
import com.example.man.demoMan.service.crud.EstablecimientoCerradoService;

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
public class EstablecimientoCerradoServiceImpl implements EstablecimientoCerradoService {
	
	/*@EJB*/
	@Autowired
	private EstablecimientoCerradoDao dao;

	@Override
	public GenericResponse create(EstablecimientoCerradoRequest establecimientoCerradoRequest) {

		GenericResponse response = new GenericResponse();
		EstablecimientoCerrado establecimientoCerrado = new EstablecimientoCerrado();
		establecimientoCerrado = validate(establecimientoCerradoRequest, 1);

		if (establecimientoCerrado != null) {
			
			Boolean res= dao.create(establecimientoCerrado);
			
			if (res) {
				
				response.setMessageId(200);
				response.setMessageDescr("Establecimiento creado exitosamente");
			} else {
				
				response.setMessageId(402);
				response.setMessageDescr("Error, no se pudo crear el establecimiento");
			}

		} else {

			response.setMessageId(401);
			response.setMessageDescr("Error en la validación de datos");

		}

		return response;
	}

	@Override
	public EstablecimientoCerradoGetAllResponse getAll() {
//		EstablecimientoCerradoGetResponse response = new EstablecimientoCerradoGetResponse();
//		response.setEstAsesor("asesor");
//		response.setEstBancoInt(true);
//		response.setEstCedProp("ced prop");
//		response.setEstCodActEco("cod act eco");
//		response.setEstCodCiudad(87654);
//		response.setEstCodigo("codigo");
//		response.setEstDireccion("direccion");
//		response.setEstEstado("estado");
//		response.setEstGR(2345);
//		response.setEstId(1);
//		response.setEstNombre("nombre");
//		response.setEstNomProp("nombre prop");
//		response.setEstRucProp("ruc prop");
//		response.setEstTelefono("telefono");
//		response.setEstUsuario("usuario");

		try {

			EstablecimientoCerradoGetAllResponse res = new EstablecimientoCerradoGetAllResponse();

			List<EstablecimientoCerradoGetResponse> list = new ArrayList<EstablecimientoCerradoGetResponse>();
			//list.add(response);
			list = dao.getAll();
			
			if (list != null) {
				res.setEstablecimientos(list);
				return res;

			} else {
				System.out.println("Error al obtener los establecimientos cerrados");
				return null;

			}

		} catch (Exception e) {
			System.out.println("Error al obtener los establecimientos cerrados");
			return null;
			
		}

	}

	@Override
	public EstablecimientoCerradoGetResponse getByName(String name) {
		EstablecimientoCerradoGetResponse response = new EstablecimientoCerradoGetResponse();
//		response.setEstAsesor("asesor");
//		response.setEstBancoInt(true);
//		response.setEstCedProp("ced prop");
//		response.setEstCodActEco("cod act eco");
//		response.setEstCodCiudad(87654);
//		response.setEstCodigo("codigo");
//		response.setEstDireccion("direccion");
//		response.setEstEstado("estado");
//		response.setEstGR(2345);
//		response.setEstId(2);
//		response.setEstNombre("nombre");
//		response.setEstNomProp("nombre prop");
//		response.setEstRucProp("ruc prop");
//		response.setEstTelefono("telefono");
//		response.setEstUsuario("usuario");

		try {
			
			response = dao.getByName(name);
			
			if (response != null) {
				return response;

			} else {
				System.out.println("Error al obtener el establecimiento cerrado");
				return null;

			}

		} catch (Exception e) {

			System.out.println("Error al obtener el establecimiento");
			return null;
		}
		
	}

	@Override
	public GenericResponse update(EstablecimientoCerradoRequest establecimientoCerradoRequest) {
		GenericResponse response = new GenericResponse();
		
		EstablecimientoCerrado establecimientoCerrado = new EstablecimientoCerrado();
		establecimientoCerrado = validate(establecimientoCerradoRequest, 2);

		if (establecimientoCerrado != null) {
			
			Boolean res= dao.update(establecimientoCerrado);
			
			if (res) {
				
				response.setMessageId(200);
				response.setMessageDescr("Establecimiento creado exitosamente");
			} else {
				
				response.setMessageId(402);
				response.setMessageDescr("Error al actualizar el establecimiento cerrado");
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
		
		EstablecimientoCerrado establecimientoCerrado = dao.getById(idEst);
		
		if (establecimientoCerrado != null) {
			
			establecimientoCerrado.setEstEstado("X");
			establecimientoCerrado.setEstFecCierre(date);
			
			Boolean res= dao.update(establecimientoCerrado);
			
			if (res) {
				
				response.setMessageId(200);
				response.setMessageDescr("Establecimiento eliminado exitosamente");
			} else {
				
				response.setMessageId(402);
				response.setMessageDescr("Error al eliminar el establecimiento cerrado");
			}

		} else {

			response.setMessageId(401);
			response.setMessageDescr("Error en la validación de datos");

		}
		
		return response;
	}

	private EstablecimientoCerrado validate(EstablecimientoCerradoRequest establecimientoCerradoRequest, int option) {

		EstablecimientoCerrado establecimientoCerrado = new EstablecimientoCerrado();

		try {
			Date date = Date.from(Instant.now());

			establecimientoCerrado.setEstAsesor(establecimientoCerradoRequest.getEstAsesor());
			establecimientoCerrado.setEstBancoInt(establecimientoCerradoRequest.getEstBancoInt());
			establecimientoCerrado.setEstCedProp(establecimientoCerradoRequest.getEstCedProp());
			establecimientoCerrado.setEstCodActEco(establecimientoCerradoRequest.getEstCodActEco());
			establecimientoCerrado.setEstCodCiudad(establecimientoCerradoRequest.getEstCodCiudad());
			establecimientoCerrado.setEstCodigo(establecimientoCerradoRequest.getEstCodigo());
			establecimientoCerrado.setEstDireccion(establecimientoCerradoRequest.getEstDireccion());
			establecimientoCerrado.setEstGR(establecimientoCerradoRequest.getEstGR());
			establecimientoCerrado.setEstNombre(establecimientoCerradoRequest.getEstNombre());
			establecimientoCerrado.setEstRucProp(establecimientoCerradoRequest.getEstRucProp());
			establecimientoCerrado.setEstTelefono(establecimientoCerradoRequest.getEstTelefono());
			establecimientoCerrado.setEstUsuario(getUser());
			
			if (option == 1) {
				//CREA
				establecimientoCerrado.setEstEstado("A");
				establecimientoCerrado.setEstFecCrea(date);
			
			} else {
				if (option == 2) {
					//Actualiza
					establecimientoCerrado.setEstFecAct(date);
				} else {
					establecimientoCerrado.setEstEstado("X");
					establecimientoCerrado.setEstFecCierre(date);
				}
			}

			return establecimientoCerrado;

		} catch (Exception e) {
			System.out.println("Error al obtener un dato para crear establecimiento");
			return null;
		}

	}

	private String getUser() {
		// TODO Obgener el usuario actual
		return null;
	}

}
