package ec.com.bancointernacional.srv.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.com.bancointernacional.model.crud.request.EstablecimientoCerradoRequest;
import ec.com.bancointernacional.model.crud.response.EstablecimientoCerradoResponse;
import ec.com.bancointernacional.service.crud.EstablecimientoCerradoService;

/*
import javax.ejb.EJB;
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
	private EstablecimientoCerradoService services;

	/*
	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	 * */
	@PostMapping(value = "/create")
	public ResponseEntity<EstablecimientoCerradoResponse> create(EstablecimientoCerradoRequest establecimientoCerradoRequest){
		
		EstablecimientoCerradoResponse response = services.create(establecimientoCerradoRequest);
		return new ResponseEntity<EstablecimientoCerradoResponse>(response, HttpStatus.OK);
	}
}
