package co.com.ceiba.parking.model;

import java.io.Serializable;

public class Price implements Serializable{
	private static final long serialVersionUID = -4087970586697604468L;
	
	private String id;
	private VehicleType idVehicleType;
	private CollectionType idCollectionType;
	private Long value;
	
	public Price() {
	}

	
	public Price(String id, VehicleType idVehicleType, CollectionType idCollectionType, Long value) {
		this.id = id;
		this.idVehicleType = idVehicleType;
		this.idCollectionType = idCollectionType;
		this.value = value;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public VehicleType getIdVehicleType() {
		return idVehicleType;
	}

	public void setIdVehicleType(VehicleType idVehicleType) {
		this.idVehicleType = idVehicleType;
	}

	public CollectionType getIdCollectionType() {
		return idCollectionType;
	}

	public void setIdCollectionType(CollectionType idCollectionType) {
		this.idCollectionType = idCollectionType;
	}

	public Long getValue() {
		return value;
	}

	public void setValue(Long value) {
		this.value = value;
	}

	
}
