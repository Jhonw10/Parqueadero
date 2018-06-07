package co.com.ceiba.parking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.UNPROCESSABLE_ENTITY)
public class ParkingException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ParkingException(String message) {
		super(message);
	}
}
