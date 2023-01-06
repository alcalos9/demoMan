package com.example.man.demoMan.controller;
/*package ec.com.bancointernacional.srv.rest;*/

import java.io.ByteArrayInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.man.demoMan.model.report.ExtIntValidationsDetailResponse;
import com.example.man.demoMan.service.crud.MatchService;
import com.example.man.demoMan.service.report.ReportService;

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


@Path("/create")
@Produces(MediaType.APPLICATION_JSON) 
 * */
@RestController
@RequestMapping("/create")
public class ReportRestful {
	
	/*@EJB*/
	@Autowired
	private ReportService services;
	
	/*
	@POST
	@Path("/report")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	 * */
	@PostMapping(value = "/report")
	public ResponseEntity<InputStreamResource> create(@RequestBody(required = true) Integer idForm){
		
		ByteArrayInputStream baits = services.getReport(idForm);
		HttpHeaders headers = new HttpHeaders();
		
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(baits));
	}
	
	
}
