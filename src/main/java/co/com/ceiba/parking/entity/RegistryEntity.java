package co.com.ceiba.parking.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import org.hibernate.annotations.GenericGenerator;

@Entity(name="Registry")
@NamedQuery(name = "Registry.findByLicensePlateActive", query = "SELECT registry from Registry registry where registry.licensePlate = :plate and registry.active = :active")
public class RegistryEntity {
	
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
		name = "UUID",
		strategy = "org.hibernate.id.UUIDGenerator"
	)
	private String id;
	
	@ManyToOne
	@JoinColumn(name="ID_VEHICLE_TYPE",referencedColumnName="id")
	private VehicleTypeEntity idVehicleType;
	
	@Column(nullable = false)
	private Date startDate;
	
	@Column(nullable = false)
	private String licensePlate;
	
	@Column(nullable = false)
	private Long displacement;
	
	@Column(nullable = false)
	private BigDecimal totalValue;
	
	@Column(nullable = false)
	private Date endDate;
	
	@Column(nullable = false, insertable=false)
	private String active;
	
	public RegistryEntity() {
	}	

	public RegistryEntity(String id, VehicleTypeEntity idVehicleType, Date startDate, String licensePlate,
			Long displacement, BigDecimal totalValue, Date endDate, String active) {
		this.id = id;
		this.idVehicleType = idVehicleType;
		this.startDate = startDate;
		this.licensePlate = licensePlate;
		this.displacement = displacement;
		this.totalValue = totalValue;
		this.endDate = endDate;
		this.active = active;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public VehicleTypeEntity getIdVehicleType() {
		return idVehicleType;
	}

	public void setIdVehicleType(VehicleTypeEntity idVehicleType) {
		this.idVehicleType = idVehicleType;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public Long getDisplacement() {
		return displacement;
	}

	public void setDisplacement(Long displacement) {
		this.displacement = displacement;
	}

	public BigDecimal getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(BigDecimal totalValue) {
		this.totalValue = totalValue;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}
	
	
	
}
