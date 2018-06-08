package co.com.ceiba.parking.entity;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class EntityTest {
	
	@Test
	public void testMustValidateSetAndGetParameterEntity() {
		ParameterEntity pe = new ParameterEntity();
		ParameterEntity val = new ParameterEntity("value", "code", "id");
		
		assertEquals(val.getValue(), "value");
		assertEquals(val.getCode(), "code");
		assertEquals(val.getId(), "id");
	}

}
