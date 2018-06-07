package co.com.ceiba.parking.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ceiba.parking.builder.PriceBuilder;
import co.com.ceiba.parking.dao.CollectionTypeDao;
import co.com.ceiba.parking.dao.PriceDao;
import co.com.ceiba.parking.dao.VehicleTypeDao;
import co.com.ceiba.parking.entity.CollectionTypeEntity;
import co.com.ceiba.parking.entity.PriceEntity;
import co.com.ceiba.parking.entity.VehicleTypeEntity;
import co.com.ceiba.parking.model.Price;
import co.com.ceiba.parking.service.PriceService;

@Service
public class PriceServiceImpl implements PriceService {

	@Autowired
	private PriceDao priceDao;
	
	@Autowired
	private VehicleTypeDao vehicleTypeDao;
	
	@Autowired
	private CollectionTypeDao collectionTypeDao;
	
	@Override
	public Price getPriceByVehicleTypeAndCollectionType(String vehicleTypeCode, String collectionTypeCode) {
		VehicleTypeEntity vehicleTypeEntity = vehicleTypeDao.getVehicleTypeByCode(vehicleTypeCode);
		CollectionTypeEntity collectionTypeEntity = collectionTypeDao.getCollectionTypeByCode(collectionTypeCode);
		List<PriceEntity> priceEntities = priceDao.getPriceBy(vehicleTypeEntity, collectionTypeEntity);
		PriceEntity priceUnique = priceEntities != null && ! priceEntities.isEmpty() ? priceEntities.get(0) : null; 
		return PriceBuilder.convertiToDomain(priceUnique);
	}

}
