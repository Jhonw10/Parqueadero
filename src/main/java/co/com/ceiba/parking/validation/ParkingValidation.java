package co.com.ceiba.parking.validation;

public interface ParkingValidation {
	boolean isValidRegistryToAdd(boolean existRegistry);
	boolean isValidRegistryToRemove(boolean existRegistry);
	boolean isValidCapacity(int total, String vehicleTypeCode);
	boolean isValidLicensePlate(int day, String licensePlate);
}
