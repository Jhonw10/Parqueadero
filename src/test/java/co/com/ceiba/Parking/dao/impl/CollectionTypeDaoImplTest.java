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

import co.com.ceiba.parking.entity.CollectionTypeEntity;
import co.com.ceiba.parking.entity.RegistryEntity;
import co.com.ceiba.parking.repository.CollectionTypeRepository;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class CollectionTypeDaoImplTest {
	
	@InjectMocks
    public CollectionTypeDaoImpl collectionTypeDaoImpl;

    @Mock
    public CollectionTypeRepository collectionTypeRepository;
    
    @Test
    public void testMustReturnListOfCollectionTypes() {
    	CollectionTypeEntity rEnt = new CollectionTypeEntity();
    	List<CollectionTypeEntity> regis = new ArrayList<CollectionTypeEntity>();
    	regis.add(rEnt);
    	Mockito.doReturn(regis).when(collectionTypeRepository).findAll();
    	
    	List<CollectionTypeEntity> result = collectionTypeDaoImpl.getCollectionTypes();
    	
    	assertNotNull(result);
    	assertFalse(result.isEmpty());
    	Mockito.verify(collectionTypeRepository).findAll();
    }
    
    @Test
    public void testMustReturnCollectionTypeWhenSearchByCode() {
    	String code = "code";
    	CollectionTypeEntity rEnt = new CollectionTypeEntity();
    	List<CollectionTypeEntity> regis = new ArrayList<CollectionTypeEntity>();
    	regis.add(rEnt);
    	Mockito.doReturn(regis).when(collectionTypeRepository).searchCollectionTypeByCode(code);
    	
    	CollectionTypeEntity result = collectionTypeDaoImpl.getCollectionTypeByCode(code);
    	
    	assertNotNull(result);
    	assertEquals(rEnt, result);
    	Mockito.verify(collectionTypeRepository).searchCollectionTypeByCode(code);
    }
    
    @Test
    public void testMustReturnNullCollectionTypeWhenSearchByCodeReturnNullOrEmpty() {
    	String code = "code";
    	List<CollectionTypeEntity> regis = new ArrayList<CollectionTypeEntity>();
    	Mockito.doReturn(regis).when(collectionTypeRepository).searchCollectionTypeByCode(code);
    	
    	CollectionTypeEntity result = collectionTypeDaoImpl.getCollectionTypeByCode(code);
    	
    	assertNull(result);
    	Mockito.verify(collectionTypeRepository).searchCollectionTypeByCode(code);
    }

}
