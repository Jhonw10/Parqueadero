package co.com.ceiba.parking.builder;

import java.util.ArrayList;
import java.util.List;

import co.com.ceiba.parking.entity.VehicleTypeEntity;
import co.com.ceiba.parking.model.VehicleType;

public class VehicleTypeBuilder {
	
	private VehicleTypeBuilder() {}
	
	public static VehicleType convertiToDomain(VehicleTypeEntity vehicleTypeEntity) {
		VehicleType vehicleType = null;
		if(vehicleTypeEntity != null) {
			vehicleType = new VehicleType(vehicleTypeEntity.getId(), vehicleTypeEntity.getCode(), vehicleTypeEntity.getName());
		}
		return vehicleType;
	}
	
	public static VehicleTypeEntity convertToEntity(VehicleType vehicleType) {
		VehicleTypeEntity vehicleTypeEntity = new VehicleTypeEntity();
		vehicleTypeEntity.setId(vehicleType.getId());
		vehicleTypeEntity.setCode(vehicleType.getCode());
		vehicleTypeEntity.setName(vehicleType.getName());
		return vehicleTypeEntity;
	}
	
	public static List<VehicleType> convertListToDomain(List<VehicleTypeEntity> vehicleTypeEntities) {
		List<VehicleType> vehiclesType = new ArrayList<VehicleType>();
		if(vehicleTypeEntities != null) {
			vehicleTypeEntities.forEach(vehicleTypeEntity -> {
				vehiclesType.add(convertiToDomain(vehicleTypeEntity));
			});
		}
		return vehiclesType;
	}
}
