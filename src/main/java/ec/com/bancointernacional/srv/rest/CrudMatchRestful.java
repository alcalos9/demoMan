package ec.com.bancointernacional.srv.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inicio")

public class CrudMatchRestful {

	
	@GetMapping(value = "/in")
	public ResponseEntity<?> init(){
		System.out.println("Hola Mundo");
		return new ResponseEntity<String>("OK", HttpStatus.OK);
	}
}
