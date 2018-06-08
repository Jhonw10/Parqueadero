package co.com.ceiba.parking.rest.impl;

import static org.junit.Assert.assertEquals;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import co.com.ceiba.parking.model.VehicleType;
import co.com.ceiba.parking.service.VehicleTypeService;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class VehicleTypeApiImplTest {
	
	@InjectMocks
    public VehicleTypeApiImpl vehicleTypeApiImpl;

    @Mock
    public VehicleTypeService vehicleTypeService;
    
    @Test
    public void testMustReturnResponseOkEntityWhenCallGetVehicleTypes() {
    	List<VehicleType> vehicleTypes = new ArrayList<VehicleType>();
    	vehicleTypes.add(new VehicleType());
    	Mockito.doReturn(vehicleTypes).when(vehicleTypeService).getAllVehiclesTypes();
    	
    	ResponseEntity result = vehicleTypeApiImpl.getVehicleTypes();
    	
    	assertNotNull(result);
    	assertEquals(result.getStatusCode(), HttpStatus.OK);
    	assertEquals(vehicleTypes, result.getBody());
    }
    
}
