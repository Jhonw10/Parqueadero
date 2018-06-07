package co.com.ceiba.parking.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ceiba.parking.builder.VehicleTypeBuilder;
import co.com.ceiba.parking.dao.VehicleTypeDao;
import co.com.ceiba.parking.model.VehicleType;
import co.com.ceiba.parking.service.VehicleTypeService;

@Component
public class VehicleTypeServiceImpl implements VehicleTypeService {
	
	@Autowired
	private VehicleTypeDao vehicleTypeDAO;
	
	@Override
	public List<VehicleType> getAllVehiclesTypes(){
		return VehicleTypeBuilder.convertListToDomain(vehicleTypeDAO.getVehicleTypes());
	}
}
