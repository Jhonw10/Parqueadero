package co.com.ceiba.parking.rest.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import co.com.ceiba.parking.model.Registry;
import co.com.ceiba.parking.rest.RegistryApi;
import co.com.ceiba.parking.service.RegistryService;

@Component
public class RegistryApiImpl implements RegistryApi{

	@Autowired
	private RegistryService registryService;
	
	@Override
	public ResponseEntity addRegistry(@Valid @RequestBody Registry registry) {
		Boolean result = this.registryService.addRegistry(registry);
		return new ResponseEntity(result, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity deleteRegistry(@QueryParam("licensePlate") String licensePlate) {
		Boolean result = this.registryService.removeRegistry(licensePlate);
		return new ResponseEntity(result, HttpStatus.OK);
	}

	@Override
	public ResponseEntity getTotalCost(@QueryParam("licensePlate") String licensePlate) {
		BigDecimal result = this.registryService.getTotalCost(licensePlate);
		return new ResponseEntity(result, HttpStatus.OK);
	}

	@Override
	public ResponseEntity getRegistries() {
		List<Registry> result = this.registryService.getRegistries();
		return new ResponseEntity(result, HttpStatus.OK);
	}
}
