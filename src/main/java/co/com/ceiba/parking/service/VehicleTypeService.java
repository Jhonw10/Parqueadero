package co.com.ceiba.parking.service;

import java.util.List;

import org.springframework.stereotype.Service;

import co.com.ceiba.parking.model.VehicleType;

@Service
public interface VehicleTypeService {
	public List<VehicleType> getAllVehiclesTypes();
}
