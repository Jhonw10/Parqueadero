package co.com.ceiba.parking.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import co.com.ceiba.parking.entity.VehicleTypeEntity;

@Repository
public interface VehicleTypeDao {
	
	List<VehicleTypeEntity> getVehicleTypes();
	VehicleTypeEntity getVehicleTypeByCode(String code);
}
