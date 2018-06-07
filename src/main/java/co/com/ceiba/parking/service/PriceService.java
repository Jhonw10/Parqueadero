package co.com.ceiba.parking.service;

import org.springframework.stereotype.Service;

import co.com.ceiba.parking.model.Price;

@Service
public interface PriceService {
	public Price getPriceByVehicleTypeAndCollectionType(String vehicleTypeCode, String collectionTypeCode);
}
