package co.com.ceiba.parking.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import co.com.ceiba.parking.entity.VehicleTypeEntity;
import co.com.ceiba.parking.repository.VehicleTypeRepository;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class VehicleTypeDaoImplTest {
	
	@InjectMocks
    public VehicleTypeDaoImpl vehicleTypeDaoImpl;

    @Mock
    public VehicleTypeRepository vehicleTypeRepository;
    
    @Test
    public void testMustReturnListOfVehicleTypesByCode() {
    	String code = "Code";
    	VehicleTypeEntity rEnt = new VehicleTypeEntity();
    	List<VehicleTypeEntity> regis = new ArrayList<VehicleTypeEntity>();
    	regis.add(rEnt);
    	Mockito.doReturn(regis).when(vehicleTypeRepository).searchVehicleTypeByCode(code);
    	
    	VehicleTypeEntity result = vehicleTypeDaoImpl.getVehicleTypeByCode(code);
    	
    	assertNotNull(result);
    	assertEquals(rEnt, result);
    	Mockito.verify(vehicleTypeRepository).searchVehicleTypeByCode(code);
    }
    
    @Test
    public void testMustReturnNullVehicleWhenListIsNullOrEmpty() {
    	String code = "Code";
    	List<VehicleTypeEntity> regis = new ArrayList<VehicleTypeEntity>();
    	Mockito.doReturn(regis).when(vehicleTypeRepository).searchVehicleTypeByCode(code);
    	
    	VehicleTypeEntity result = vehicleTypeDaoImpl.getVehicleTypeByCode(code);
    	
    	assertNull(result);
    	Mockito.verify(vehicleTypeRepository).searchVehicleTypeByCode(code);
    }
    
    @Test
    public void testMustReturnAllListOfVehicleTypesWhenGetAll() {
    	VehicleTypeEntity rEnt = new VehicleTypeEntity();
    	List<VehicleTypeEntity> regis = new ArrayList<VehicleTypeEntity>();
    	regis.add(rEnt);
    	Mockito.doReturn(regis).when(vehicleTypeRepository).findAll();
    	
    	List<VehicleTypeEntity> result = vehicleTypeDaoImpl.getVehicleTypes();
    	
    	assertNotNull(result);
    	assertFalse(result.isEmpty());
    	Mockito.verify(vehicleTypeRepository).findAll();
    }

}
