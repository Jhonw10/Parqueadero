package co.com.ceiba.parking.service.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import co.com.ceiba.parking.dao.CollectionTypeDao;
import co.com.ceiba.parking.dao.PriceDao;
import co.com.ceiba.parking.dao.VehicleTypeDao;
import co.com.ceiba.parking.entity.CollectionTypeEntity;
import co.com.ceiba.parking.entity.PriceEntity;
import co.com.ceiba.parking.entity.VehicleTypeEntity;
import co.com.ceiba.parking.model.Price;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class PriceServiceImplTest {
	
	@InjectMocks
    private PriceServiceImpl priceServiceImpl;
	
	@Mock
	private PriceDao priceDao;
	
	@Mock
	private VehicleTypeDao vehicleTypeDao;
	
	@Mock
	private CollectionTypeDao collectionTypeDao;
	
	@Test
	public void testMustGetPriceByVehicleAndCollectAndCallFunctionsAndReturnValue() {
		String vehicleTypeCode = "AUTOMOVIL";
		String collectionTypeCode = "DIA";
		List<PriceEntity> prices = new ArrayList<PriceEntity>();
		prices.add(new PriceEntity());
		Mockito.doReturn(new VehicleTypeEntity()).when(vehicleTypeDao).getVehicleTypeByCode(vehicleTypeCode);
		Mockito.doReturn(new CollectionTypeEntity()).when(collectionTypeDao).getCollectionTypeByCode(collectionTypeCode);
		Mockito.doReturn(prices).when(priceDao).getPriceBy(Mockito.any(), Mockito.any());
		
		Price result = priceServiceImpl.getPriceByVehicleTypeAndCollectionType(vehicleTypeCode, collectionTypeCode);
		
		assertNotNull(result);
		Mockito.verify(vehicleTypeDao, Mockito.times(1)).getVehicleTypeByCode(vehicleTypeCode);
		Mockito.verify(collectionTypeDao, Mockito.times(1)).getCollectionTypeByCode(collectionTypeCode);
		Mockito.verify(priceDao, Mockito.times(1)).getPriceBy(Mockito.any(), Mockito.any());
	}
	
	@Test
	public void testMustReturnNullWhenSearchByVehicleAndCollectAndCallFunctionsNotReturnValue() {
		String vehicleTypeCode = "AUTOMOVIL";
		String collectionTypeCode = "DIA";
		List<PriceEntity> prices = new ArrayList<PriceEntity>();
		Mockito.doReturn(new VehicleTypeEntity()).when(vehicleTypeDao).getVehicleTypeByCode(vehicleTypeCode);
		Mockito.doReturn(new CollectionTypeEntity()).when(collectionTypeDao).getCollectionTypeByCode(collectionTypeCode);
		Mockito.doReturn(prices).when(priceDao).getPriceBy(Mockito.any(), Mockito.any());
		
		Price result = priceServiceImpl.getPriceByVehicleTypeAndCollectionType(vehicleTypeCode, collectionTypeCode);
		
		assertNull(result);
		Mockito.verify(vehicleTypeDao, Mockito.times(1)).getVehicleTypeByCode(vehicleTypeCode);
		Mockito.verify(collectionTypeDao, Mockito.times(1)).getCollectionTypeByCode(collectionTypeCode);
		Mockito.verify(priceDao, Mockito.times(1)).getPriceBy(Mockito.any(), Mockito.any());
	}
	
	@Test
	public void testMustReturnNullWhenSearchByVehicleAndCollectAndCallFunctionsReturnNull() {
		String vehicleTypeCode = "AUTOMOVIL";
		String collectionTypeCode = "DIA";
		Mockito.doReturn(new VehicleTypeEntity()).when(vehicleTypeDao).getVehicleTypeByCode(vehicleTypeCode);
		Mockito.doReturn(new CollectionTypeEntity()).when(collectionTypeDao).getCollectionTypeByCode(collectionTypeCode);
		Mockito.doReturn(null).when(priceDao).getPriceBy(Mockito.any(), Mockito.any());
		
		Price result = priceServiceImpl.getPriceByVehicleTypeAndCollectionType(vehicleTypeCode, collectionTypeCode);
		
		assertNull(result);
		Mockito.verify(vehicleTypeDao, Mockito.times(1)).getVehicleTypeByCode(vehicleTypeCode);
		Mockito.verify(collectionTypeDao, Mockito.times(1)).getCollectionTypeByCode(collectionTypeCode);
		Mockito.verify(priceDao, Mockito.times(1)).getPriceBy(Mockito.any(), Mockito.any());
	}
	

}
