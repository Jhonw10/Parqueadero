package co.com.ceiba.parking.service.impl;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ceiba.parking.builder.PriceBuilder;
import co.com.ceiba.parking.builder.RegistryBuilder;
import co.com.ceiba.parking.builder.VehicleTypeBuilder;
import co.com.ceiba.parking.dao.PriceDao;
import co.com.ceiba.parking.dao.RegistryDao;
import co.com.ceiba.parking.dao.VehicleTypeDao;
import co.com.ceiba.parking.entity.PriceEntity;
import co.com.ceiba.parking.entity.RegistryEntity;
import co.com.ceiba.parking.model.Registry;
import co.com.ceiba.parking.model.VehicleType;
import co.com.ceiba.parking.service.RegistryService;
import co.com.ceiba.parking.util.ParkingUtil;
import co.com.ceiba.parking.validation.ParkingValidation;

@Component
public class RegistryServiceImpl implements RegistryService {
	
	@Autowired
	private RegistryDao registryDao;
	
	@Autowired
	private PriceDao priceDao;
	
	@Autowired
	private VehicleTypeDao vehicleTypeDao;
	
	@Autowired
	private ParkingValidation parkingValidation;
	
	@Autowired
	private ParkingUtil parkingUtil;
	

	@Override
	public Boolean addRegistry(Registry registry) {
		Calendar day = Calendar.getInstance();
		List<RegistryEntity> registries = registryDao.getRegistryByLicensePlateAndStatus(registry.getLicensePlate(), "1");
		parkingValidation.isValidRegistryToAdd(registries == null ? false : !registries.isEmpty());
		int total = registryDao.getCountRegistryStatusByVehicleType(registry.getVehicleTypeCode(), "1");
		parkingValidation.isValidCapacity(total, registry.getVehicleTypeCode());		
		parkingValidation.isValidLicensePlate(day.get(Calendar.DAY_OF_WEEK), registry.getLicensePlate());
		VehicleType vehicleType= VehicleTypeBuilder.convertiToDomain(vehicleTypeDao.getVehicleTypeByCode(registry.getVehicleTypeCode()));
		registry.setIdVehicleType(vehicleType);
		registry.setStartDate(day.getTime());
		Boolean add = registryDao.addRegistry(RegistryBuilder.convertToEntity(registry));
		return add;
	}

	@Override
	public Boolean removeRegistry(String licensePlate) {
		List<RegistryEntity> registries = registryDao.getRegistryByLicensePlateAndStatus(licensePlate, "1");
		BigDecimal totalCost = getTotalCost(licensePlate);
		RegistryEntity registryEntity = registries.get(0);
		registryEntity.setEndDate(new Date());
		registryEntity.setActive("0");
		registryEntity.setTotalValue(totalCost);
		Boolean add = registryDao.updateRegistry(registryEntity);
		return add;
	}

	@Override
	public BigDecimal getTotalCost(String licensePlate) {
		List<RegistryEntity> registries = registryDao.getRegistryByLicensePlateAndStatus(licensePlate, "1");
		parkingValidation.isValidRegistryToRemove(registries == null ? false : !registries.isEmpty());
		List<PriceEntity> prices = priceDao.getAllPrices();
		RegistryEntity registryEntity = registries.get(0);
		BigDecimal totalCost = parkingUtil.calculateChargedToVehicle(RegistryBuilder.convertiToDomain(registryEntity), PriceBuilder.convertListToDomain(prices));
		return totalCost;
	}

	@Override
	public List<Registry> getRegistries() {
		List<RegistryEntity> registries = registryDao.getRegistriesByStatus("1");
		return RegistryBuilder.convertListToDomain(registries);
	}

}
