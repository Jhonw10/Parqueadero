package co.com.ceiba.parking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.com.ceiba.parking.entity.RegistryEntity;

public interface RegistryRepository extends JpaRepository<RegistryEntity, Long> {
	
	@Query("SELECT registry from Registry registry where registry.licensePlate = :plate and registry.active = :active")
	List<RegistryEntity> searchRegistryByLicensePlateActive(@Param("plate") String plate, @Param("active") String active);

	@Query("SELECT COUNT(registry) from Registry registry where registry.idVehicleType.code = :code and registry.active = :active")
	Integer getCountRegistryStatusByVehicleType(@Param("code") String code, @Param("active") String active);
	
	@Query("SELECT registry from Registry registry where registry.active = :active")
	List<RegistryEntity> searchRegistryByStatus(@Param("active") String active);
}
