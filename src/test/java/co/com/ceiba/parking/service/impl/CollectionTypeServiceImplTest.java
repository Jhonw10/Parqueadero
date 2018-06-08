package co.com.ceiba.parking.service.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

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

import co.com.ceiba.parking.dao.CollectionTypeDao;
import co.com.ceiba.parking.entity.CollectionTypeEntity;
import co.com.ceiba.parking.model.CollectionType;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class CollectionTypeServiceImplTest {
	
	@InjectMocks
    private CollectionTypeServiceImpl collectionTypeServiceImpl;

    @Mock
    private CollectionTypeDao collectTypeDao;
    
	@Before
	public void setUp() {
	}
	
	@Test
	public void testMustReturnGetAllCollectionsTypeData() {
		
		List<CollectionTypeEntity> listEnt = new ArrayList<CollectionTypeEntity>();
		listEnt.add(new CollectionTypeEntity());
		Mockito.doReturn(listEnt).when(collectTypeDao).getCollectionTypes();
		
		List<CollectionType> result = collectionTypeServiceImpl.getAllCollectionTypes();
		
		assertNotNull(result);
		assertFalse(result.isEmpty());
	}

}
