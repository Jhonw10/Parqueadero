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
