package co.com.ceiba.Parking;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import co.com.ceiba.parking.Example;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExampleTest {
	
	@Test
	public void testMustReturnTrueValue() {
		Example ex = new Example();
		boolean result = ex.returBooleanValue();
		
		assertTrue(result);
	}

}
