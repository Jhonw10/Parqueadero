package co.com.ceiba.parking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;


@Entity(name="Price")
@NamedQuery(name = "Price.findByVehicleTypeAndCollectionType", query = "SELECT price from Price price where price.idVehicleType = :idVehicleType and price.idCollectionType = :idCollectionType")
public class PriceEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	
	@ManyToOne
	@JoinColumn(name="ID_VEHICLE_TYPE",referencedColumnName="id")
	private VehicleTypeEntity idVehicleType;
	
	@ManyToOne
	@JoinColumn(name="ID_COLLECTION_TYPE",referencedColumnName="id")
	private CollectionTypeEntity idCollectionType;
	
	@Column(nullable = false)
	private Long value;
	
	public PriceEntity() {
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

	public CollectionTypeEntity getIdCollectionType() {
		return idCollectionType;
	}

	public void setIdCollectionType(CollectionTypeEntity idCollectionType) {
		this.idCollectionType = idCollectionType;
	}

	public Long getValue() {
		return value;
	}

	public void setValue(Long value) {
		this.value = value;
	}
	
}
