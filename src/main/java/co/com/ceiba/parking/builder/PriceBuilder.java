package co.com.ceiba.parking.builder;

import java.util.ArrayList;
import java.util.List;

import co.com.ceiba.parking.entity.PriceEntity;
import co.com.ceiba.parking.model.Price;

public class PriceBuilder {
	
	private PriceBuilder() {}
	
	public static Price convertiToDomain(PriceEntity priceEntity) {
		Price price = null;
		if(priceEntity != null) {
			price = new Price(priceEntity.getId(), 
					VehicleTypeBuilder.convertiToDomain(priceEntity.getIdVehicleType()), 
					CollectionTypeBuilder.convertiToDomain(priceEntity.getIdCollectionType()), 
					priceEntity.getValue());
		}
		return price;
	}
	
	public static PriceEntity convertToEntity(Price price) {
		PriceEntity priceEntity = new PriceEntity();
		priceEntity.setId(price.getId());
		priceEntity.setIdCollectionType(CollectionTypeBuilder.convertToEntity(price.getIdCollectionType()));
		priceEntity.setIdVehicleType(VehicleTypeBuilder.convertToEntity(price.getIdVehicleType()));
		priceEntity.setValue(price.getValue());
		return priceEntity;
	}
	
	public static List<Price> convertListToDomain(List<PriceEntity> priceEntities) {
		List<Price> prices = new ArrayList<Price>();
		if(priceEntities != null) {
			priceEntities.forEach(priceEntity -> {
				prices.add(convertiToDomain(priceEntity));
			});
		}
		return prices;
	}
}
