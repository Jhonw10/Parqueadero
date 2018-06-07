package co.com.ceiba.parking.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import co.com.ceiba.parking.entity.RegistryEntity;

@Repository
public interface RegistryDao {
	
	Boolean addRegistry(RegistryEntity registryEntity);
	
	Boolean updateRegistry(RegistryEntity registryEntity);
	
	List<RegistryEntity> getRegistryByLicensePlateAndStatus(String licensePlate, String status);
	
	List<RegistryEntity> getRegistriesByStatus(String active);
	
	Integer getCountRegistryStatusByVehicleType(String vehicleTypeCode, String active);
	
}
