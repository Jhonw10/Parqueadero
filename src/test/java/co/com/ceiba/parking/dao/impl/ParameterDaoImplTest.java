package co.com.ceiba.parking.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import co.com.ceiba.parking.repository.ParameterRepository;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class ParameterDaoImplTest {
	
	@InjectMocks
    public ParameterDaoImpl parameterDaoImpl;

    @Mock
    public ParameterRepository parameterRepository;
    
    @Test
    public void testMustReturnStringValueParameterWhenSearchByCode() {
    	String code = "code";
    	String expc = "Rest";
    	Mockito.doReturn(expc).when(parameterRepository).searchParameterValueByCode(code);
    	
    	String result = parameterDaoImpl.getParameterByCode(code);
    	
    	assertNotNull(result);
    	assertEquals(expc, result);
    	Mockito.verify(parameterRepository).searchParameterValueByCode(code);
    }

}
