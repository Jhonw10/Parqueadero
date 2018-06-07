package co.com.ceiba.parking.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Registry {
	@JsonIgnore
	private String id;
	@NotNull
    @Size(min=4, max=20)
	private String vehicleTypeCode;
	private Date startDate;
	@NotNull
    @Size(min=4, max=7)
	private String licensePlate;
	@NotNull
	@Min(0)
	@Max(10000)
	private Long displacement;
	@JsonIgnore
	private BigDecimal totalValue;
	@JsonIgnore
	private Date endDate;
	@JsonIgnore
	private String active;
	@JsonIgnore
	private VehicleType idVehicleType;
}
