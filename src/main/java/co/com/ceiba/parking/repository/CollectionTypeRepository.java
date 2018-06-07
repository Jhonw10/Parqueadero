package co.com.ceiba.parking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.com.ceiba.parking.entity.CollectionTypeEntity;

public interface CollectionTypeRepository extends JpaRepository<CollectionTypeEntity, Long> {
	
	@Query("SELECT collectType from CollectionType collectType where collectType.code = :code")
	List<CollectionTypeEntity> searchCollectionTypeByCode(@Param("code") String code);

}
