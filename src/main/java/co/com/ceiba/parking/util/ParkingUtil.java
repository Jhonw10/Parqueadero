package co.com.ceiba.parking.util;

import java.math.BigDecimal;
import java.util.List;

import co.com.ceiba.parking.model.Price;
import co.com.ceiba.parking.model.Registry;

public interface ParkingUtil {
	BigDecimal calculateChargedToVehicle(Registry registry, List<Price> prices);
}
