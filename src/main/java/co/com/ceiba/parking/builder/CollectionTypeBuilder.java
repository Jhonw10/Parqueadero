package co.com.ceiba.parking.builder;

import java.util.ArrayList;
import java.util.List;

import co.com.ceiba.parking.entity.CollectionTypeEntity;
import co.com.ceiba.parking.model.CollectionType;

public class CollectionTypeBuilder {
	
	private CollectionTypeBuilder() {}
	
	public static CollectionType convertiToDomain(CollectionTypeEntity CollectionTypeEntity) {
		CollectionType CollectionType = null;
		if(CollectionTypeEntity != null) {
			CollectionType = new CollectionType(CollectionTypeEntity.getId(), CollectionTypeEntity.getCode(), CollectionTypeEntity.getName());
		}
		return CollectionType;
	}
	
	public static CollectionTypeEntity convertToEntity(CollectionType CollectionType) {
		CollectionTypeEntity CollectionTypeEntity = new CollectionTypeEntity();
		CollectionTypeEntity.setId(CollectionType.getId());
		CollectionTypeEntity.setCode(CollectionType.getCode());
		CollectionTypeEntity.setName(CollectionType.getName());
		return CollectionTypeEntity;
	}
	
	public static List<CollectionType> convertListToDomain(List<CollectionTypeEntity> CollectionTypeEntities) {
		List<CollectionType> vehiclesType = new ArrayList<CollectionType>();
		if(CollectionTypeEntities != null) {
			CollectionTypeEntities.forEach(CollectionTypeEntity -> {
				vehiclesType.add(convertiToDomain(CollectionTypeEntity));
			});
		}
		return vehiclesType;
	}
}
