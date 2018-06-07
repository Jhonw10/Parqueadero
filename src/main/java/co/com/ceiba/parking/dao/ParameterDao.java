package co.com.ceiba.parking.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface ParameterDao {
	
	String getParameterByCode(String code);
}
