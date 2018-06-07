package co.com.ceiba.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.com.ceiba.parking.entity.ParameterEntity;

public interface ParameterRepository extends JpaRepository<ParameterEntity, Long> {
	
	@Query("SELECT parameter.value from Parameter parameter where parameter.code = :code")
	String searchParameterValueByCode(@Param("code") String code);
}
