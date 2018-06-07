package co.com.ceiba.parking.validation.impl;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import co.com.ceiba.parking.dao.ParameterDao;
import co.com.ceiba.parking.exception.ParkingException;
import co.com.ceiba.parking.exception.VehicleNotFoundException;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class ParkingValidationImplTest {
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	@InjectMocks
    private ParkingValidationImpl parkingImpl;

    @Mock
    private ParameterDao parameterDao;

	@Before
	public void setUp() {
	}

	@Test
	public void testMustReturnExceptionWhenVehicleExist() {
		boolean exist = true;
		thrown.expect(ParkingException.class);
		thrown.expectMessage("Vehicle is already in the parking");
				
		parkingImpl.isValidRegistryToAdd(exist);
	}
	
	@Test
	public void testMustReturnTrueWhenVehicleNotExist() {
		boolean exist = false;
				
		boolean result = parkingImpl.isValidRegistryToAdd(exist);
		
		assertTrue(result);
	}
	
	@Test
	public void testMustReturnExceptionWhenVehicleIsNotValidToRemove() {
		boolean remove = false;
		thrown.expect(VehicleNotFoundException.class);
		thrown.expectMessage("Vehicle is not in the parking");
				
		parkingImpl.isValidRegistryToRemove(remove);
	}
	
	@Test
	public void testMustReturnTrueWhenVehicleIsValidRemove() {
		boolean remove = true;
				
		boolean result = parkingImpl.isValidRegistryToRemove(remove);
		
		assertTrue(result);
	}
	
	@Test
	public void testMustReturnExceptionWhenVehicleParkingCapacityIsFull() {
		Mockito.doReturn("2").when(parameterDao).getParameterByCode("VH_CAPAC");
		String vehicleCode = "AUTOMOVIL";
		thrown.expect(ParkingException.class);
		thrown.expectMessage("The parking is full");
		
		parkingImpl.isValidCapacity(2, vehicleCode);
	}
	
	@Test
	public void testMustReturnExceptionWhenMotoParkingCapacityIsFull() {
		Mockito.doReturn("2").when(parameterDao).getParameterByCode("MT_CAPAC");
		String motoCode = "MOTO";
		thrown.expect(ParkingException.class);
		thrown.expectMessage("The parking is full");
		
		parkingImpl.isValidCapacity(2, motoCode);
	}
	
	@Test
	public void testMustReturnExceptionWhenVehicleIsNotMotoAndAuto() {
		String tracCode = "TRACKTOR";
		thrown.expect(ParkingException.class);
		thrown.expectMessage("The parking is full");
		
		parkingImpl.isValidCapacity(2, tracCode);
	}
	
	@Test
	public void testMustReturnTrueWhenCapacityIsValid() {
		Mockito.doReturn("3").when(parameterDao).getParameterByCode("VH_CAPAC");
		String vehicleCode = "AUTOMOVIL";
		
		boolean result = parkingImpl.isValidCapacity(2, vehicleCode);
		
		assertTrue(result);
	}
	
	@Test
	public void testMustReturnExceptionWhenPlateBeginWithAAndDayIsNotSunday() {
		String license = "AJSLPO";
		Mockito.doReturn("A").when(parameterDao).getParameterByCode("VAL_LETT");
		thrown.expect(ParkingException.class);
		thrown.expectMessage("Can not enter because you are not in a business day");
		
		parkingImpl.isValidLicensePlate(3, license);
	}
	
	@Test
	public void testMustReturnTrueWhenDayIsSundayValidToPlate() {
		String license = "AJSLPO";
		Mockito.doReturn("A").when(parameterDao).getParameterByCode("VAL_LETT");
		
		boolean result = parkingImpl.isValidLicensePlate(1, license);
		
		assertTrue(result);
	}
	
	@Test
	public void testMustReturnTrueWhenDayIsMondayValidToPlate() {
		String license = "aJSLPO";
		Mockito.doReturn("A").when(parameterDao).getParameterByCode("VAL_LETT");
		
		boolean result = parkingImpl.isValidLicensePlate(2, license);
		
		assertTrue(result);
	}

}
