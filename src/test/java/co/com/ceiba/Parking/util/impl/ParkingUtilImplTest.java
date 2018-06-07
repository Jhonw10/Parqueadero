package co.com.ceiba.parking.util.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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

import static org.junit.Assert.assertEquals;

import co.com.ceiba.parking.dao.ParameterDao;
import co.com.ceiba.parking.model.CollectionType;
import co.com.ceiba.parking.model.Price;
import co.com.ceiba.parking.model.Registry;
import co.com.ceiba.parking.model.VehicleType;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class ParkingUtilImplTest {
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	@InjectMocks
    private ParkingUtilImpl parkingUtilImpl;

    @Mock
    private ParameterDao parameterDao;
    
    private Registry registry;

	@Before
	public void setUp() {
		parkingUtilImpl = Mockito.spy(parkingUtilImpl);
	}
	
	@Test
	public void testMustCalculateCostToVehicleTo20Hours() {
		registry = new Registry();
		Calendar date = Calendar.getInstance();
		date.add(Calendar.HOUR_OF_DAY, -27);
		registry.setStartDate(date.getTime());
		registry.setVehicleTypeCode("AUTOMOVIL");
		Mockito.doReturn(1000L).when(parkingUtilImpl).getValueByListPrices(null, "AUTOMOVIL", "HORA");
		Mockito.doReturn(8000L).when(parkingUtilImpl).getValueByListPrices(null, "AUTOMOVIL", "DIA");
		
		BigDecimal result = parkingUtilImpl.calculateChargedToVehicle(registry, null);
		
		BigDecimal expected = new BigDecimal(11000);
		assertEquals(expected, result);
		Mockito.verify(parkingUtilImpl, Mockito.times(2)).getValueByListPrices(Mockito.any(), Mockito.any(), Mockito.any());
	}
	
	@Test
	public void testMustCalculateCostToMotoTo10Hours() {
		registry = new Registry();
		Calendar date = Calendar.getInstance();
		date.add(Calendar.HOUR_OF_DAY, -10);
		registry.setStartDate(date.getTime());
		registry.setVehicleTypeCode("MOTO");
		registry.setDisplacement(501L);
		Mockito.doReturn(500L).when(parkingUtilImpl).getValueByListPrices(null, "MOTO", "HORA");
		Mockito.doReturn(4000L).when(parkingUtilImpl).getValueByListPrices(null, "MOTO", "DIA");
		Mockito.doReturn(2000L).when(parkingUtilImpl).getValueByListPrices(null, "MOTO", "RECARGO");
		Mockito.doReturn("500").when(parameterDao).getParameterByCode("MT_MAXCC");
		
		BigDecimal result = parkingUtilImpl.calculateChargedToVehicle(registry, null);
		
		BigDecimal expected = new BigDecimal(6000);
		assertEquals(expected, result);
		Mockito.verify(parkingUtilImpl, Mockito.times(3)).getValueByListPrices(Mockito.any(), Mockito.any(), Mockito.any());
		Mockito.verify(parameterDao, Mockito.times(1)).getParameterByCode(Mockito.any());
	}
	
	@Test
	public void testMustGetLongValueToListPricesByCode() {
		VehicleType veh = new VehicleType();
		veh.setCode("AUTOMOVIL");
		CollectionType coll = new CollectionType();
		coll.setCode("DIA");
		Price price = new Price();
		price.setIdVehicleType(veh);
		price.setIdCollectionType(coll);
		price.setValue(100L);
		List<Price> prices = new ArrayList<Price>();
		prices.add(price);
		
		Long result = parkingUtilImpl.getValueByListPrices(prices, "AUTOMOVIL", "DIA");
		
		Long expected = 100L;
		assertEquals(expected, result);
	}

}
