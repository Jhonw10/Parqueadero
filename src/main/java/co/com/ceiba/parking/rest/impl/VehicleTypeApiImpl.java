package co.com.ceiba.parking.rest.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import co.com.ceiba.parking.model.VehicleType;
import co.com.ceiba.parking.rest.VehicleTypeApi;
import co.com.ceiba.parking.service.VehicleTypeService;

@Component
public class VehicleTypeApiImpl implements VehicleTypeApi {
	
	@Autowired
	private VehicleTypeService vehicleTypeService;
	
	@Override
	public ResponseEntity getVehicleTypes(){
		List<VehicleType> vehicleTypes = this.vehicleTypeService.getAllVehiclesTypes();
		return new ResponseEntity(vehicleTypes, HttpStatus.OK);
	}
}
