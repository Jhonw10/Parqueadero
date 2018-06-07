package co.com.ceiba.parking.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import co.com.ceiba.parking.dao.PriceDao;
import co.com.ceiba.parking.dao.RegistryDao;
import co.com.ceiba.parking.dao.VehicleTypeDao;
import co.com.ceiba.parking.entity.PriceEntity;
import co.com.ceiba.parking.entity.RegistryEntity;
import co.com.ceiba.parking.entity.VehicleTypeEntity;
import co.com.ceiba.parking.model.Registry;
import co.com.ceiba.parking.util.ParkingUtil;
import co.com.ceiba.parking.validation.ParkingValidation;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class RegistryServiceImplTest {
	
	@InjectMocks
    private RegistryServiceImpl registryServiceImpl;
	
	@Mock
	private RegistryDao registryDao;
	
    @Mock
	private PriceDao priceDao;

    @Mock
    private VehicleTypeDao vehicleTypeDao;
	
    @Mock
	private ParkingValidation parkingValidation;
	
    @Mock
	private ParkingUtil parkingUtil;
    
    private Registry registry;
    
	@Before
	public void setUp() {
		registryServiceImpl = Mockito.spy(registryServiceImpl);
	}
	
	@Test
	public void testMustCallAdditionalMethodsToAddRegistryInServiceWhenExistResults() {
		registry = new Registry();
		registry = Mockito.spy(registry);
		registry.setLicensePlate("A12345");
		registry.setVehicleTypeCode("AUTOMOVIL");
		registry.setVehicleTypeCode("AUTOMOVIL");
		List<RegistryEntity> registries = new ArrayList<RegistryEntity>();
		registries.add(new RegistryEntity());
		Mockito.doReturn(registries).when(registryDao).getRegistryByLicensePlateAndStatus(Mockito.anyString(), Mockito.anyString());
		Mockito.doReturn(true).when(parkingValidation).isValidRegistryToAdd(Mockito.anyBoolean());
		Mockito.doReturn(0).when(registryDao).getCountRegistryStatusByVehicleType(Mockito.anyString(), Mockito.anyString());
		Mockito.doReturn(true).when(parkingValidation).isValidCapacity(Mockito.anyInt(), Mockito.any());
		Mockito.doReturn(true).when(parkingValidation).isValidLicensePlate(Mockito.anyInt(), Mockito.any());
		Mockito.doReturn(new VehicleTypeEntity()).when(vehicleTypeDao).getVehicleTypeByCode(Mockito.anyString());
		Mockito.doReturn(true).when(registryDao).addRegistry(Mockito.any());
		
		Boolean result = registryServiceImpl.addRegistry(registry);	
		
		assertTrue(result);
		Mockito.verify(registryDao, Mockito.times(1)).getRegistryByLicensePlateAndStatus(Mockito.anyString(), Mockito.anyString());
		Mockito.verify(parkingValidation, Mockito.times(1)).isValidRegistryToAdd(Mockito.anyBoolean());
		Mockito.verify(registryDao, Mockito.times(1)).getCountRegistryStatusByVehicleType(Mockito.anyString(), Mockito.anyString());
		Mockito.verify(parkingValidation, Mockito.times(1)).isValidCapacity(Mockito.anyInt(), Mockito.any());
		Mockito.verify(parkingValidation, Mockito.times(1)).isValidLicensePlate(Mockito.anyInt(), Mockito.any());
		Mockito.verify(vehicleTypeDao, Mockito.times(1)).getVehicleTypeByCode(Mockito.anyString());
		Mockito.verify(registryDao, Mockito.times(1)).addRegistry(Mockito.any());
		Mockito.verify(registry, Mockito.times(1)).setStartDate(Mockito.any());
		Mockito.verify(registry, Mockito.times(1)).setIdVehicleType(Mockito.any());
	}
	
	@Test
	public void testMustCallAdditionalMethodsToAddRegistryInServiceWhenNotExistResults() {
		registry = new Registry();
		registry = Mockito.spy(registry);
		registry.setLicensePlate("A12345");
		registry.setVehicleTypeCode("AUTOMOVIL");
		registry.setVehicleTypeCode("AUTOMOVIL");
		Mockito.doReturn(null).when(registryDao).getRegistryByLicensePlateAndStatus(Mockito.anyString(), Mockito.anyString());
		Mockito.doReturn(true).when(parkingValidation).isValidRegistryToAdd(Mockito.anyBoolean());
		Mockito.doReturn(0).when(registryDao).getCountRegistryStatusByVehicleType(Mockito.anyString(), Mockito.anyString());
		Mockito.doReturn(true).when(parkingValidation).isValidCapacity(Mockito.anyInt(), Mockito.any());
		Mockito.doReturn(true).when(parkingValidation).isValidLicensePlate(Mockito.anyInt(), Mockito.any());
		Mockito.doReturn(new VehicleTypeEntity()).when(vehicleTypeDao).getVehicleTypeByCode(Mockito.anyString());
		Mockito.doReturn(true).when(registryDao).addRegistry(Mockito.any());
		
		Boolean result = registryServiceImpl.addRegistry(registry);	
		
		assertTrue(result);
		Mockito.verify(registryDao, Mockito.times(1)).getRegistryByLicensePlateAndStatus(Mockito.anyString(), Mockito.anyString());
		Mockito.verify(parkingValidation, Mockito.times(1)).isValidRegistryToAdd(Mockito.anyBoolean());
		Mockito.verify(registryDao, Mockito.times(1)).getCountRegistryStatusByVehicleType(Mockito.anyString(), Mockito.anyString());
		Mockito.verify(parkingValidation, Mockito.times(1)).isValidCapacity(Mockito.anyInt(), Mockito.any());
		Mockito.verify(parkingValidation, Mockito.times(1)).isValidLicensePlate(Mockito.anyInt(), Mockito.any());
		Mockito.verify(vehicleTypeDao, Mockito.times(1)).getVehicleTypeByCode(Mockito.anyString());
		Mockito.verify(registryDao, Mockito.times(1)).addRegistry(Mockito.any());
		Mockito.verify(registry, Mockito.times(1)).setStartDate(Mockito.any());
		Mockito.verify(registry, Mockito.times(1)).setIdVehicleType(Mockito.any());
	}
	
	@Test
	public void testMustCallAllFunctionsToRemoveRegistryWhenIsValidAndExist() {
		String plate = "A12345";
		BigDecimal bd = new BigDecimal(1000);
		List<RegistryEntity> listReg = new ArrayList<RegistryEntity>();
		RegistryEntity rEnt = new RegistryEntity();
		rEnt = Mockito.spy(rEnt);
		listReg.add(rEnt);
		Mockito.doReturn(listReg).when(registryDao).getRegistryByLicensePlateAndStatus(Mockito.anyString(), Mockito.anyString());
		Mockito.doReturn(bd).when(registryServiceImpl).getTotalCost(plate);
		Mockito.doReturn(true).when(registryDao).updateRegistry(Mockito.any());
		
		Boolean result = registryServiceImpl.removeRegistry(plate);	
		
		assertTrue(result);
		Mockito.verify(rEnt, Mockito.times(1)).setEndDate(Mockito.any());
		Mockito.verify(rEnt, Mockito.times(1)).setActive(Mockito.any());
		Mockito.verify(rEnt, Mockito.times(1)).setTotalValue(bd);
		Mockito.verify(registryDao, Mockito.times(1)).getRegistryByLicensePlateAndStatus(Mockito.anyString(), Mockito.anyString());
		Mockito.verify(registryServiceImpl, Mockito.times(1)).getTotalCost(plate);
		Mockito.verify(registryDao, Mockito.times(1)).updateRegistry(Mockito.any());
	}
	
	@Test
	public void testMustCallFunctionToCalculateCostWhenResultIsNotNull() {
		String plate = "A12345";
		BigDecimal bd = new BigDecimal(1000);
		List<RegistryEntity> listReg = new ArrayList<RegistryEntity>();
		RegistryEntity rEnt = new RegistryEntity();
		rEnt.setIdVehicleType(new VehicleTypeEntity());
		rEnt = Mockito.spy(rEnt);
		listReg.add(rEnt);
		List<PriceEntity> prices = new ArrayList<PriceEntity>();
		Mockito.doReturn(listReg).when(registryDao).getRegistryByLicensePlateAndStatus(Mockito.anyString(), Mockito.anyString());
		Mockito.doReturn(true).when(parkingValidation).isValidRegistryToRemove(Mockito.anyBoolean());
		Mockito.doReturn(prices).when(priceDao).getAllPrices();
		Mockito.doReturn(bd).when(parkingUtil).calculateChargedToVehicle(Mockito.any(), Mockito.any());
		
		BigDecimal result = registryServiceImpl.getTotalCost(plate);
		
		assertEquals(bd, result);
		Mockito.verify(registryDao, Mockito.times(1)).getRegistryByLicensePlateAndStatus(Mockito.anyString(), Mockito.anyString());
		Mockito.verify(parkingValidation, Mockito.times(1)).isValidRegistryToRemove(Mockito.anyBoolean());
		Mockito.verify(priceDao, Mockito.times(1)).getAllPrices();
		Mockito.verify(parkingUtil, Mockito.times(1)).calculateChargedToVehicle(Mockito.any(), Mockito.any());
	}
	
	@Test
	public void testMustReturnAllListOfRegistries() {
		List<RegistryEntity> listReg = new ArrayList<RegistryEntity>();
		RegistryEntity rEnt = new RegistryEntity();
		VehicleTypeEntity vt = new VehicleTypeEntity();
		vt.setCode("AUTO");
		rEnt.setIdVehicleType(new VehicleTypeEntity());
		rEnt.setActive("1");
		rEnt.setDisplacement(100L);
		rEnt.setStartDate(new Date());
		rEnt.setLicensePlate("A123");
		rEnt = Mockito.spy(rEnt);
		listReg.add(rEnt);
		Mockito.doReturn(listReg).when(registryDao).getRegistriesByStatus("1");
		
		List<Registry> result = registryServiceImpl.getRegistries();
		
		assertNotNull(result);
		assertFalse(result.isEmpty());
		Mockito.verify(registryDao, Mockito.times(1)).getRegistriesByStatus("1");
		assertEquals(result.get(0).getActive(), rEnt.getActive());
		assertEquals(result.get(0).getVehicleTypeCode(), rEnt.getIdVehicleType().getCode());
		assertEquals(result.get(0).getDisplacement(), rEnt.getDisplacement());
		assertEquals(result.get(0).getStartDate(), rEnt.getStartDate());
		assertEquals(result.get(0).getLicensePlate(), rEnt.getLicensePlate());
	}
}
