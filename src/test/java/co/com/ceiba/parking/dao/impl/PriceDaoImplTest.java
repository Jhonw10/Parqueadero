package co.com.ceiba.parking.dao.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import co.com.ceiba.parking.entity.PriceEntity;
import co.com.ceiba.parking.repository.PriceRepository;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class PriceDaoImplTest {
	
	@InjectMocks
    public PriceDaoImpl priceDaoImpl;

    @Mock
    public PriceRepository priceRepository;

    @Test
    public void testMustReturnListOfPriceTypes() {
    	PriceEntity rEnt = new PriceEntity();
    	List<PriceEntity> regis = new ArrayList<PriceEntity>();
    	regis.add(rEnt);
    	Mockito.doReturn(regis).when(priceRepository).searchPriceByVehicleTypeAndCollectionType(Mockito.any(), Mockito.any());
    	
    	List<PriceEntity> result = priceDaoImpl.getPriceBy(null, null);
    	
    	assertNotNull(result);
    	assertFalse(result.isEmpty());
    	Mockito.verify(priceRepository).searchPriceByVehicleTypeAndCollectionType(Mockito.any(), Mockito.any());
    }
    
    @Test
    public void testMustReturnAllListOfPricesWhenGetAll() {
    	PriceEntity rEnt = new PriceEntity();
    	List<PriceEntity> regis = new ArrayList<PriceEntity>();
    	regis.add(rEnt);
    	Mockito.doReturn(regis).when(priceRepository).findAll();
    	
    	List<PriceEntity> result = priceDaoImpl.getAllPrices();
    	
    	assertNotNull(result);
    	assertFalse(result.isEmpty());
    	Mockito.verify(priceRepository).findAll();
    }

}
