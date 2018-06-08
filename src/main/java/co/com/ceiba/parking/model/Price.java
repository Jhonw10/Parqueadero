package co.com.ceiba.parking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Price{
	private String id;
	private VehicleType idVehicleType;
	private CollectionType idCollectionType;
	private Long value;
}
