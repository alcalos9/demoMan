package com.example.man.demoMan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.man.demoMan.model.crud.request.EstablecimientoCerradoRequest;
import com.example.man.demoMan.model.crud.response.EstablecimientoCerradoGetAllResponse;
import com.example.man.demoMan.model.crud.response.EstablecimientoCerradoGetResponse;
import com.example.man.demoMan.model.crud.response.GenericResponse;
import com.example.man.demoMan.service.crud.EstablecimientoCerradoService;

/*

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;


@Path("/crudEstCer")
@Produces(MediaType.APPLICATION_JSON) 
 * */
@RestController
@RequestMapping("/crudEstCer")
public class CrudEstablecimientoCerradoRestful {
	
	/*@EJB*/
	@Autowired
	private EstablecimientoCerradoService services;

	/*
	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	 * */
	@PostMapping(value = "/create")
	public ResponseEntity<GenericResponse> create(@RequestBody(required = true) EstablecimientoCerradoRequest establecimientoCerradoRequest){
		
		GenericResponse response = services.create(establecimientoCerradoRequest);
		return new ResponseEntity<GenericResponse>(response, HttpStatus.OK);
	}
	
	/*
	@GET
	@Path("/getAll")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	 * */
	@GetMapping(value = "/getAll")
	public ResponseEntity<EstablecimientoCerradoGetAllResponse> getAll(){
		
		EstablecimientoCerradoGetAllResponse response = services.getAll();
		return new ResponseEntity<EstablecimientoCerradoGetAllResponse>(response, HttpStatus.OK);
	}
	
	/*
	@POST
	@Path("/getByName")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	 * */
	@PostMapping(value = "/getByName")
	public ResponseEntity<EstablecimientoCerradoGetResponse> getByName(@RequestBody(required = true) String name){
		
		EstablecimientoCerradoGetResponse response = services.getByName(name);
		return new ResponseEntity<EstablecimientoCerradoGetResponse>(response, HttpStatus.OK);
	}
	
	/*
	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	 * */
	@PutMapping(value = "/update")
	public ResponseEntity<GenericResponse> update(@RequestBody(required = true) EstablecimientoCerradoRequest establecimientoCerradoRequest){
		
		GenericResponse response = services.update(establecimientoCerradoRequest);
		return new ResponseEntity<GenericResponse>(response, HttpStatus.OK);
	}
	
	/*
	@PUT
	@Path("/delete")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	 * */
	@PutMapping(value = "/delete")
	public ResponseEntity<GenericResponse> delete(@RequestBody(required = true) Integer idEst){
		
		GenericResponse response = services.delete(idEst);
		return new ResponseEntity<GenericResponse>(response, HttpStatus.OK);
	}
	
}
