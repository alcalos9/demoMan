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

import com.example.man.demoMan.model.crud.request.MatchRequest;
import com.example.man.demoMan.model.crud.response.GenericResponse;
import com.example.man.demoMan.model.crud.response.MatchGetAllResponse;
import com.example.man.demoMan.model.crud.response.MatchGetResponse;
import com.example.man.demoMan.service.crud.MatchService;

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
@RequestMapping("/crudMatch")
public class CrudMatchRestful {
	
	/*@EJB*/
	@Autowired
	private MatchService services;
	
	/*
	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	 * */
	@PostMapping(value = "/create")
	public ResponseEntity<GenericResponse> create(@RequestBody(required = true) MatchRequest matchRequest){
		
		GenericResponse response = services.create(matchRequest);
		return new ResponseEntity<GenericResponse>(response, HttpStatus.OK);
	}
	
	/*
	@GET
	@Path("/getAll")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	 * */
	@GetMapping(value = "/getAll")
	public ResponseEntity<MatchGetAllResponse> getAll(){
		
		MatchGetAllResponse response = services.getAll();
		return new ResponseEntity<MatchGetAllResponse>(response, HttpStatus.OK);
	}
	
	/*
	@POST
	@Path("/getByName")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	 * */
	@PostMapping(value = "/getByName")
	public ResponseEntity<MatchGetResponse> getByName(@RequestBody(required = true) String name){
		
		MatchGetResponse response = services.getByName(name);
		return new ResponseEntity<MatchGetResponse>(response, HttpStatus.OK);
	}
	
	/*
	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	 * */
	@PutMapping(value = "/update")
	public ResponseEntity<GenericResponse> update(@RequestBody(required = true) MatchRequest matchRequest){
		
		GenericResponse response = services.update(matchRequest);
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
