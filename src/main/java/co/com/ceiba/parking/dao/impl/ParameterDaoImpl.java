package co.com.ceiba.parking.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import co.com.ceiba.parking.dao.ParameterDao;
import co.com.ceiba.parking.repository.ParameterRepository;

@Component
public class ParameterDaoImpl implements ParameterDao {
	
	@Autowired
	private ParameterRepository parameterRepository;

	@Override
	@Cacheable("parameters")
	public String getParameterByCode(String code) {
		return parameterRepository.searchParameterValueByCode(code);
	}
	
}
