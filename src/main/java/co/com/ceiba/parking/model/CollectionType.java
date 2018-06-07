package co.com.ceiba.parking.model;

import java.io.Serializable;

public class CollectionType implements Serializable{
	private static final long serialVersionUID = -4087970586697604468L;
	
	private String id;
	private String code;
	private String name;
	
	public CollectionType() {
	}

	public CollectionType(String name, String code, String id) {
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
