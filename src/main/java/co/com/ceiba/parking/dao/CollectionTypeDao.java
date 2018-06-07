package co.com.ceiba.parking.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import co.com.ceiba.parking.entity.CollectionTypeEntity;

@Repository
public interface CollectionTypeDao {
	
	List<CollectionTypeEntity> getCollectionTypes();
	CollectionTypeEntity getCollectionTypeByCode(String code);
}
