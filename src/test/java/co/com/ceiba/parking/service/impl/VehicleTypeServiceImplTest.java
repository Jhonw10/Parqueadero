package co.com.ceiba.parking.service.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import co.com.ceiba.parking.dao.VehicleTypeDao;
import co.com.ceiba.parking.entity.VehicleTypeEntity;
import co.com.ceiba.parking.model.VehicleType;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class VehicleTypeServiceImplTest {

	@InjectMocks
    private VehicleTypeServiceImpl vehicleServiceImpl;

    @Mock
    private VehicleTypeDao vehicleTypeDao;
    
	@Before
	public void setUp() {
		vehicleServiceImpl = Mockito.spy(vehicleServiceImpl);
	}
	
	@Test
	public void testMustReturnListOfVehicleTypesWhenExist() {
		VehicleTypeEntity vEnt = new VehicleTypeEntity(); 
		vEnt.setCode("CODE");
		vEnt.setId("ID");
		vEnt.setName("NAME");
		List<VehicleTypeEntity> listVEnt = new ArrayList<VehicleTypeEntity>();
		listVEnt.add(vEnt);
		Mockito.doReturn(listVEnt).when(vehicleTypeDao).getVehicleTypes();
		
		List<VehicleType> listVehicle = vehicleServiceImpl.getAllVehiclesTypes();
		
		assertNotNull(listVehicle);
		assertFalse(listVehicle.isEmpty());
		assertEquals(listVehicle.get(0).getCode(), vEnt.getCode());
		assertEquals(listVehicle.get(0).getId(), vEnt.getId());
		assertEquals(listVehicle.get(0).getName(), vEnt.getName());
	}
}
