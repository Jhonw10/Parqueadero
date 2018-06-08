package co.com.ceiba.parking.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class ModelTest {

	@Test
	public void testMustValidateSetAndGetRegistry() {
		Registry registry = new Registry();
		Date date = new Date();
		BigDecimal bd = new BigDecimal(100);
		Long ld = 100L;
		Registry registry2 = new Registry("id", "code", date, "license", 
				ld, bd,date, "1", null);
		
		assertEquals(registry2.getActive(), "1");
		assertEquals(registry2.getId(), "id");
		assertEquals(registry2.getVehicleTypeCode(), "code");
		assertEquals(registry2.getStartDate(), date);
		assertEquals(registry2.getEndDate(), date);
		assertEquals(registry2.getDisplacement(), ld);
		assertEquals(registry2.getLicensePlate(), "license");
		assertEquals(registry2.getTotalValue(), bd);
		assertNull(registry2.getIdVehicleType());
	}
	
	@Test
	public void testMustValidateSetAndGetPrice() {
		Price price = new Price();
		Long ld = 100L;
		Price val = new Price("id", null, null, ld);
		
		assertEquals(val.getId(), "id");
		assertNull(val.getIdVehicleType());
		assertNull(val.getIdCollectionType());
		assertEquals(val.getValue(), ld);
	}
	
	@Test
	public void testMustValidateSetAndGetCollectionType() {
		CollectionType coll = new CollectionType();
		CollectionType val = new CollectionType("id", "code", "name");
		
		assertEquals(val.getId(), "id");
		assertEquals(val.getCode(), "code");
		assertEquals(val.getName(), "name");
	}
	
	@Test
	public void testMustValidateSetAndGetVehicleType() {
		VehicleType vehi = new VehicleType();
		VehicleType val = new VehicleType("id", "code", "name");
		
		assertEquals(val.getId(), "id");
		assertEquals(val.getCode(), "code");
		assertEquals(val.getName(), "name");
	}
}
