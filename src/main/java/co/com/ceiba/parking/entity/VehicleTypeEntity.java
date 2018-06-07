package co.com.ceiba.parking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity(name="VehicleType")
@NamedQuery(name = "VehicleType.findByCode", query = "SELECT vehicleType from VehicleType vehicleType where vehicleType.code = :code")
public class VehicleTypeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	
	@Column(nullable = false)
	private String code;
	
	@Column(nullable = false)
	private String name;
	
	public VehicleTypeEntity() {
	}

	public VehicleTypeEntity(String name, String code, String id) {
		this.name = name;
		this.code = code;
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
}
