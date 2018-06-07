package co.com.ceiba.parking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.com.ceiba.parking.entity.CollectionTypeEntity;
import co.com.ceiba.parking.entity.PriceEntity;
import co.com.ceiba.parking.entity.VehicleTypeEntity;

public interface PriceRepository extends JpaRepository<PriceEntity, Long> {
	
	@Query("SELECT price from Price price where price.idVehicleType = :idVehicleTypeEntity and price.idCollectionType = :idCollectionTypeEntity")
	List<PriceEntity> searchPriceByVehicleTypeAndCollectionType(@Param("idVehicleTypeEntity") VehicleTypeEntity idVehicleTypeEntity, @Param("idCollectionTypeEntity") CollectionTypeEntity idCollectionTypeEntity);

}
