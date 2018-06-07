package co.com.ceiba.parking.validation.impl;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ceiba.parking.dao.ParameterDao;
import co.com.ceiba.parking.exception.ParkingException;
import co.com.ceiba.parking.exception.VehicleNotFoundException;
import co.com.ceiba.parking.validation.ParkingValidation;

@Component
public class ParkingValidationImpl implements ParkingValidation {
	
	@Autowired
	private ParameterDao parameterDao;
	
	private static String CODE_VEHICLE_CAPACITY = "VH_CAPAC";
	private static String CODE_MOTORCICLE_CAPACITY = "MT_CAPAC";
	private static String CODE_LETTER_VALIDATE = "VAL_LETT";
	private static String CODE_VEHICLE = "AUTOMOVIL";
	private static String CODE_MOTORCYCLE = "MOTO";
	private static String VEHICLE_ALREADY_IN_THE_PARKING = "Vehicle is already in the parking";
	private static String VEHICLE_IS_NOT_IN_THE_PARKING = "Vehicle is not in the parking";
	private static String PARKING_IS_FULL = "The parking is full";
	private static String VEHICLE_CAN_NOT_ENTRY = "Can not enter because you are not in a business day";
	
	@Override
	public boolean isValidRegistryToAdd(boolean existRegistry) {
		if (existRegistry) {
			throw new ParkingException(VEHICLE_ALREADY_IN_THE_PARKING);
		}
		return true;
	}
	
	@Override
	public boolean isValidRegistryToRemove(boolean existRegistry) {
		if (! existRegistry) {
			throw new VehicleNotFoundException(VEHICLE_IS_NOT_IN_THE_PARKING);
		}
		return true;
	}

	@Override
	public boolean isValidCapacity(int total, String vehicleTypeCode) {
		if((vehicleTypeCode.equals(CODE_VEHICLE) && 
				total >= Integer.parseInt(parameterDao.getParameterByCode(CODE_VEHICLE_CAPACITY))) || 
			(vehicleTypeCode.equals(CODE_MOTORCYCLE) && 
					total >= Integer.parseInt(parameterDao.getParameterByCode(CODE_MOTORCICLE_CAPACITY))) ||
			(! vehicleTypeCode.equals(CODE_VEHICLE) && !vehicleTypeCode.equals(CODE_MOTORCYCLE))) {
			throw new ParkingException(PARKING_IS_FULL);
		}
		return true;
	}

	@Override
	public boolean isValidLicensePlate(int day, String licensePlate) {
		String firstLetter= licensePlate.substring(0, 1).toUpperCase();
		if(firstLetter.equals(parameterDao.getParameterByCode(CODE_LETTER_VALIDATE)) 
				&& (day != Calendar.SUNDAY && day != Calendar.MONDAY)) {
			throw new ParkingException(VEHICLE_CAN_NOT_ENTRY);
		}
		return true;
	}
}
