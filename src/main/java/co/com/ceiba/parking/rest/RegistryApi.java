package co.com.ceiba.parking.rest;

import javax.validation.Valid;
import javax.ws.rs.QueryParam;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.parking.model.Registry;

@RestController
public interface RegistryApi {

	@RequestMapping(value = "/registry", 
			method = RequestMethod.POST,
			produces = {MediaType.APPLICATION_JSON_VALUE}, 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity addRegistry(@Valid @RequestBody Registry registry);
	
	@DeleteMapping(value = "/registry", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity deleteRegistry(@QueryParam("licensePlate") String licensePlate);
	
	@GetMapping(value = "/registry/cost", produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity getTotalCost(@QueryParam("licensePlate") String licensePlate);
	
	@GetMapping(value = "/registry", produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity getRegistries();
}
