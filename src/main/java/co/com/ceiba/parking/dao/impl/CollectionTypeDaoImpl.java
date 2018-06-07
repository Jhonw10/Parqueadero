package co.com.ceiba.parking.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ceiba.parking.dao.CollectionTypeDao;
import co.com.ceiba.parking.entity.CollectionTypeEntity;
import co.com.ceiba.parking.repository.CollectionTypeRepository;

@Component
public class CollectionTypeDaoImpl implements CollectionTypeDao{
	
	@Autowired
	private CollectionTypeRepository collectionTypeRepository;
	
	@Override
	public List<CollectionTypeEntity> getCollectionTypes() {
		return collectionTypeRepository.findAll();
	}

	@Override
	public CollectionTypeEntity getCollectionTypeByCode(String code) {
		List<CollectionTypeEntity> collection = collectionTypeRepository.searchCollectionTypeByCode(code);
		return collection != null && !collection.isEmpty() ? collection.get(0) : null;
	}
	
}
