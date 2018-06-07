package co.com.ceiba.parking.service;

import java.util.List;

import org.springframework.stereotype.Service;

import co.com.ceiba.parking.model.CollectionType;

@Service
public interface CollectionTypeService {
	public List<CollectionType> getAllCollectionTypes();
}
