package co.com.ceiba.parking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleType{
	private String id;
	private String code;
	private String name;
}
