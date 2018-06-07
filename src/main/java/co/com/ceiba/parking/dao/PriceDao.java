package co.com.ceiba.parking.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import co.com.ceiba.parking.entity.CollectionTypeEntity;
import co.com.ceiba.parking.entity.PriceEntity;
import co.com.ceiba.parking.entity.VehicleTypeEntity;

@Repository
public interface PriceDao {
	
	List<PriceEntity> getPriceBy(VehicleTypeEntity idVehicleTypeEntity, CollectionTypeEntity idCollectionTypeEntity);
	List<PriceEntity> getAllPrices();

}
