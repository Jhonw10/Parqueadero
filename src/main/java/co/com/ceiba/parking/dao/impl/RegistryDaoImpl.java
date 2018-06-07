package co.com.ceiba.parking.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ceiba.parking.dao.RegistryDao;
import co.com.ceiba.parking.entity.RegistryEntity;
import co.com.ceiba.parking.repository.RegistryRepository;

@Component
public class RegistryDaoImpl implements RegistryDao{

	@Autowired
	private RegistryRepository registryRepository;
	
	@Override
	public Boolean addRegistry(RegistryEntity registryEntity) {
		RegistryEntity result = registryRepository.save(registryEntity);
		return result != null;
	}

	@Override
	public Boolean updateRegistry(RegistryEntity registryEntity) {
		RegistryEntity result = registryRepository.save(registryEntity);
		return result != null;
	}

	@Override
	public List<RegistryEntity>  getRegistryByLicensePlateAndStatus(String licensePlate, String status) {
		return registryRepository.searchRegistryByLicensePlateActive(licensePlate, status);
	}

	@Override
	public Integer getCountRegistryStatusByVehicleType(String vehicleTypeCode, String active) {
		return registryRepository.getCountRegistryStatusByVehicleType(vehicleTypeCode, active);
	}

	@Override
	public List<RegistryEntity> getRegistriesByStatus(String active) {
		return registryRepository.searchRegistryByStatus(active);
	}

}
