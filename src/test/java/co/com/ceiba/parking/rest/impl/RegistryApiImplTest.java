package co.com.ceiba.parking.rest.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import co.com.ceiba.parking.model.Registry;
import co.com.ceiba.parking.model.VehicleType;
import co.com.ceiba.parking.service.RegistryService;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class RegistryApiImplTest {
	@InjectMocks
    public RegistryApiImpl registryApiImpl;

    @Mock
    public RegistryService registryServiceService;
    
    @Test
    public void testMustReturnResponseCreatedEntityWhenCallAddRegistry() {
    	Registry registry = new Registry();
    	Mockito.doReturn(true).when(registryServiceService).addRegistry(registry);

    	ResponseEntity result = registryApiImpl.addRegistry(registry);
    	
    	assertNotNull(result);
    	assertEquals(result.getStatusCode(), HttpStatus.CREATED);
    	assertEquals(true, result.getBody());
    	Mockito.verify(registryServiceService).addRegistry(registry);
    }
    
    @Test
    public void testMustReturnResponseOkEntityWhenCallDeleteRegistry() {
    	String plate = "A123";
    	Mockito.doReturn(true).when(registryServiceService).removeRegistry(plate);

    	ResponseEntity result = registryApiImpl.deleteRegistry(plate);
    	
    	assertNotNull(result);
    	assertEquals(result.getStatusCode(), HttpStatus.OK);
    	assertEquals(true, result.getBody());
    	Mockito.verify(registryServiceService).removeRegistry(plate);
    }
    
    @Test
    public void testMustReturnResponseOkEntityWhenCallGetTotalCost() {
    	String plate = "A123";
    	BigDecimal bd = new BigDecimal(123);
    	Mockito.doReturn(bd).when(registryServiceService).getTotalCost(plate);

    	ResponseEntity result = registryApiImpl.getTotalCost(plate);
    	
    	assertNotNull(result);
    	assertEquals(result.getStatusCode(), HttpStatus.OK);
    	assertEquals(bd, result.getBody());
    	Mockito.verify(registryServiceService).getTotalCost(plate);
    }
    
    @Test
    public void testMustReturnResponseOkEntityWhenCallGetRegistries() {
    	List<Registry> regis = new ArrayList<Registry>();
    	Mockito.doReturn(regis).when(registryServiceService).getRegistries();

    	ResponseEntity result = registryApiImpl.getRegistries();
    	
    	assertNotNull(result);
    	assertEquals(result.getStatusCode(), HttpStatus.OK);
    	assertEquals(regis, result.getBody());
    	Mockito.verify(registryServiceService).getRegistries();
    }
}
