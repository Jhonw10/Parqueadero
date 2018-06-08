package co.com.ceiba.parking.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import co.com.ceiba.parking.entity.RegistryEntity;
import co.com.ceiba.parking.repository.RegistryRepository;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class RegistryDaoImplTest {
	
	@InjectMocks
    public RegistryDaoImpl registryDaoImpl;

    @Mock
    public RegistryRepository registryRepository;
    
    @Test
    public void testMustReturnTrueValueWhenCallSaveRegistry() {
    	RegistryEntity rEnt = new RegistryEntity();
    	Mockito.doReturn(rEnt).when(registryRepository).save(Mockito.any());
    	Boolean result = registryDaoImpl.addRegistry(new RegistryEntity());
    	
    	assertTrue(result);
    	Mockito.verify(registryRepository).save(Mockito.any());
    }
    
    @Test
    public void testMustReturnTrueValueWhenCallUpdateRegistry() {
    	RegistryEntity rEnt = new RegistryEntity();
    	Mockito.doReturn(rEnt).when(registryRepository).save(Mockito.any());
    	Boolean result = registryDaoImpl.updateRegistry(new RegistryEntity());
    	
    	assertTrue(result);
    	Mockito.verify(registryRepository).save(Mockito.any());
    }
    
    @Test
    public void testMustReturnListRegistryWhenCallGetRegistryByLicense() {
    	RegistryEntity rEnt = new RegistryEntity();
    	List<RegistryEntity> regis = new ArrayList<RegistryEntity>();
    	regis.add(rEnt);
    	Mockito.doReturn(regis).when(registryRepository).searchRegistryByLicensePlateActive(Mockito.anyString(), Mockito.anyString());
    	
    	List<RegistryEntity> result = registryDaoImpl.getRegistryByLicensePlateAndStatus("Plate", "1");
    	
    	assertNotNull(result);
    	assertFalse(result.isEmpty());
    	Mockito.verify(registryRepository).searchRegistryByLicensePlateActive(Mockito.anyString(), Mockito.anyString());
    }
    
    @Test
    public void testMustReturnListRegistryWhenCallGetAllActiveRegistry() {
    	RegistryEntity rEnt = new RegistryEntity();
    	List<RegistryEntity> regis = new ArrayList<RegistryEntity>();
    	regis.add(rEnt);
    	Mockito.doReturn(regis).when(registryRepository).searchRegistryByStatus(Mockito.anyString());
    	
    	List<RegistryEntity> result = registryDaoImpl.getRegistriesByStatus("1");
    	
    	assertNotNull(result);
    	assertFalse(result.isEmpty());
    	Mockito.verify(registryRepository).searchRegistryByStatus(Mockito.anyString());
    }
    
    @Test
    public void testMustReturnCountVehicleWhenCallGetRegistryByLicenseAndStatus() {
    	Integer co = 10;
    	RegistryEntity rEnt = new RegistryEntity();
    	List<RegistryEntity> regis = new ArrayList<RegistryEntity>();
    	regis.add(rEnt);
    	Mockito.doReturn(co).when(registryRepository).getCountRegistryStatusByVehicleType(Mockito.anyString(), Mockito.anyString());
    	
    	Integer result = registryDaoImpl.getCountRegistryStatusByVehicleType("Plate", "1");
    	
    	assertNotNull(result);
    	assertEquals(co, result);    	
    	Mockito.verify(registryRepository).getCountRegistryStatusByVehicleType(Mockito.anyString(), Mockito.anyString());
    }

}
