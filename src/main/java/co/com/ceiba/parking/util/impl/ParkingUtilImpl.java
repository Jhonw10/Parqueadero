package co.com.ceiba.parking.util.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ceiba.parking.dao.ParameterDao;
import co.com.ceiba.parking.model.Price;
import co.com.ceiba.parking.model.Registry;
import co.com.ceiba.parking.util.ParkingUtil;

@Component
public class ParkingUtilImpl implements ParkingUtil {

	@Autowired
	private ParameterDao parameterDao;
	
	private static String CODE_VEHICLE = "AUTOMOVIL";
	private static String CODE_MOTORCYCLE = "MOTO";
	private static String CODE_HOUR = "HORA";
	private static String CODE_DAY = "DIA";
	private static String CODE_RECHARGE = "RECARGO";
	private static String CODE_MAX_CC_VALIDATE = "MT_MAXCC";
	
	@Override
	public BigDecimal calculateChargedToVehicle(Registry registry, List<Price> prices) {
		long diff = new Date().getTime() - registry.getStartDate().getTime();
		long hours = TimeUnit.MILLISECONDS.toHours(diff);
		long chargedByDay = hours / 24; 
		long chargedByHour = hours % 24;
		chargedByDay = chargedByDay + (chargedByHour > 9 ? 1 : 0);
		chargedByHour = chargedByHour > 9 ? 0 : chargedByHour;
		BigDecimal value = new BigDecimal(0);
		if(registry.getVehicleTypeCode().equals(CODE_VEHICLE)) {
			value = new BigDecimal(getValueByListPrices(prices,CODE_VEHICLE,CODE_HOUR) * chargedByHour);
			value = value.add(new BigDecimal(getValueByListPrices(prices,CODE_VEHICLE, CODE_DAY) * chargedByDay));
		}else if (registry.getVehicleTypeCode().equals(CODE_MOTORCYCLE)){
			value = new BigDecimal(getValueByListPrices(prices, CODE_MOTORCYCLE, CODE_HOUR) * chargedByHour);
			value = value.add(new BigDecimal(getValueByListPrices(prices, CODE_MOTORCYCLE, CODE_DAY) * chargedByDay));
			value = registry.getDisplacement() > Integer.parseInt(parameterDao.getParameterByCode(CODE_MAX_CC_VALIDATE)) ? 
					value.add(new BigDecimal(getValueByListPrices(prices, CODE_MOTORCYCLE, CODE_RECHARGE))) : value;
		}
		return value;
	}
	
	public Long getValueByListPrices(List<Price> prices, String codeVehicle, String codeCollect) {
		return prices.stream().filter(x -> x.getIdVehicleType().getCode().equals(codeVehicle)
				&& x.getIdCollectionType().getCode().equals(codeCollect)).findFirst().get().getValue();
	}

}
