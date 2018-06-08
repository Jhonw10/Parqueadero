package co.com.ceiba.parking.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

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
		val.setValue("value");
		val.setCode("code");
		val.setId("id");
		assertEquals(val.getValue(), "value");
		assertEquals(val.getCode(), "code");
		assertEquals(val.getId(), "id");
	}
	
	@Test
	public void testMustValidateSetAndGetCollectionEntity() {
		CollectionTypeEntity pe = new CollectionTypeEntity();
		CollectionTypeEntity val = new CollectionTypeEntity("name", "code", "id");
		val.setName("name");
		val.setCode("code");
		val.setId("id");
		assertEquals(val.getName(), "name");
		assertEquals(val.getCode(), "code");
		assertEquals(val.getId(), "id");
	}
	
	@Test
	public void testMustValidateSetAndGetPriceEntity() {
		PriceEntity pe = new PriceEntity();
		Long lo = 100L;
		pe.setId("id");
		pe.setIdCollectionType(null);
		pe.setIdVehicleType(null);
		pe.setValue(lo);
		
		assertNull(pe.getIdCollectionType());
		assertNull(pe.getIdVehicleType());
		assertEquals(pe.getValue(),lo);
		assertEquals(pe.getId(), "id");
	}
	
	@Test
	public void testMustValidateSetAndGetVehicleEntity() {
		VehicleTypeEntity pe = new VehicleTypeEntity();
		VehicleTypeEntity val = new VehicleTypeEntity("name", "code", "id");
		val.setName("name");
		val.setCode("code");
		val.setId("id");
		
		assertEquals(val.getName(), "name");
		assertEquals(val.getCode(), "code");
		assertEquals(val.getId(), "id");
	}

}
