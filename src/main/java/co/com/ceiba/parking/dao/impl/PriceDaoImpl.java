package co.com.ceiba.parking.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ceiba.parking.dao.PriceDao;
import co.com.ceiba.parking.entity.CollectionTypeEntity;
import co.com.ceiba.parking.entity.PriceEntity;
import co.com.ceiba.parking.entity.VehicleTypeEntity;
import co.com.ceiba.parking.repository.PriceRepository;

@Component
public class PriceDaoImpl implements PriceDao{

	@Autowired
	private PriceRepository priceRepository;
	
	@Override
	public List<PriceEntity> getPriceBy(VehicleTypeEntity idVehicleTypeEntity, CollectionTypeEntity idCollectionTypeEntity) {
		return priceRepository.searchPriceByVehicleTypeAndCollectionType(idVehicleTypeEntity, idCollectionTypeEntity);
	}

	@Override
	public List<PriceEntity> getAllPrices() {
		return priceRepository.findAll();
	}

}
