package co.com.ceiba.parking.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import co.com.ceiba.parking.model.Registry;

@Service
public interface RegistryService {

	Boolean addRegistry(Registry registry);
	Boolean removeRegistry(String licensePlate);
	BigDecimal getTotalCost(String licensePlate);
	List<Registry> getRegistries();
}
