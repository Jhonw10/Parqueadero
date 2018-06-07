package co.com.ceiba.parking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import co.com.ceiba.parking.entity.VehicleTypeEntity;

public interface VehicleTypeRepository extends JpaRepository<VehicleTypeEntity, Long> {
	
	@Query("SELECT vehicleType FROM VehicleType vehicleType WHERE vehicleType.code = :code")
	List<VehicleTypeEntity> searchVehicleTypeByCode(@Param("code") String code);

}
