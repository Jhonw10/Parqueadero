package co.com.ceiba.parking.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ceiba.parking.dao.VehicleTypeDao;
import co.com.ceiba.parking.entity.VehicleTypeEntity;
import co.com.ceiba.parking.repository.VehicleTypeRepository;

@Component
public class VehicleTypeDaoImpl implements VehicleTypeDao {
	
	@Autowired
	private VehicleTypeRepository vehicleTypeRepository;
	
	@Override
	public List<VehicleTypeEntity> getVehicleTypes(){
		return vehicleTypeRepository.findAll();
	}
	
	@Override
	public VehicleTypeEntity getVehicleTypeByCode(String code) {
		List<VehicleTypeEntity> vehicleTypes = vehicleTypeRepository.searchVehicleTypeByCode(code);
		return vehicleTypes != null && !vehicleTypes.isEmpty() ? vehicleTypes.get(0) : null;
	}
	
}
