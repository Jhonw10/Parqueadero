package co.com.ceiba.parking.builder;

import java.util.ArrayList;
import java.util.List;

import co.com.ceiba.parking.entity.RegistryEntity;
import co.com.ceiba.parking.model.Registry;

public class RegistryBuilder {
	
	private RegistryBuilder() {}
	
	public static Registry convertiToDomain(RegistryEntity registryEntity) {
		Registry registry = null;
		if(registryEntity != null) {
			registry = new Registry(registryEntity.getId(), 
					registryEntity.getIdVehicleType().getCode(), 
					registryEntity.getStartDate(),
					registryEntity.getLicensePlate(),
					registryEntity.getDisplacement(),
					registryEntity.getTotalValue(),
					registryEntity.getEndDate(),
					registryEntity.getActive(),
					null);
		}
		return registry;
	}
	
	public static RegistryEntity convertToEntity(Registry registry) {
		RegistryEntity registryEntity = new RegistryEntity();
		registryEntity.setId(registry.getId());
		registryEntity.setIdVehicleType(VehicleTypeBuilder.convertToEntity(registry.getIdVehicleType()));
		registryEntity.setStartDate(registry.getStartDate());
		registryEntity.setLicensePlate(registry.getLicensePlate());
		registryEntity.setDisplacement(registry.getDisplacement());
		registryEntity.setTotalValue(registry.getTotalValue());
		registryEntity.setEndDate(registry.getEndDate());
		registryEntity.setActive(registry.getActive());
		return registryEntity;
	}
	
	public static List<Registry> convertListToDomain(List<RegistryEntity> registryEntities) {
		List<Registry> registries = new ArrayList<Registry>();
		if(registryEntities != null) {
			registryEntities.forEach(priceEntity -> {
				registries.add(convertiToDomain(priceEntity));
			});
		}
		return registries;
	}
}
