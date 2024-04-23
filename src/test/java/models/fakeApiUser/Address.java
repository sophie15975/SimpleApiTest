package models.fakeApiUser;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@Builder

public class Address{

	@JsonProperty("zipcode")
	private String zipcode;

	@JsonProperty("number")
	private int number;

	public Address(String zipcode, int number, String city, String street, Geolocation geolocation) {
		this.zipcode = zipcode;
		this.number = number;
		this.city = city;
		this.street = street;
		this.geolocation = geolocation;
	}
	public  Address(){

	}

	@JsonProperty("city")
	private String city;

	@JsonProperty("street")
	private String street;

	@JsonProperty("geolocation")
	private Geolocation geolocation;
}