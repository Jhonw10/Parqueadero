package co.com.ceiba.parking.rest;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface VehicleTypeApi {
	
	@GetMapping(value = "/vehicleTypes", produces= {MediaType.APPLICATION_JSON_VALUE})
	ResponseEntity getVehicleTypes();

}
