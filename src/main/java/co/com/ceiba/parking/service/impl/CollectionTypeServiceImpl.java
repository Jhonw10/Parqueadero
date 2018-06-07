package co.com.ceiba.parking.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ceiba.parking.builder.CollectionTypeBuilder;
import co.com.ceiba.parking.dao.CollectionTypeDao;
import co.com.ceiba.parking.model.CollectionType;
import co.com.ceiba.parking.service.CollectionTypeService;

@Component
public class CollectionTypeServiceImpl implements CollectionTypeService {
	
	@Autowired
	private CollectionTypeDao collectionTypeDao;
	
	@Override
	public List<CollectionType> getAllCollectionTypes(){
		return CollectionTypeBuilder.convertListToDomain(collectionTypeDao.getCollectionTypes());
	}
}
