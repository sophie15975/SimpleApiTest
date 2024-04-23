package models.fakeApiUser;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@NoArgsConstructor
//@Builder

public class Geolocation{

	@JsonProperty("lat")
	private String lat;

	public Geolocation(String lat, String jsonMemberLong) {
		this.lat = lat;
		this.jsonMemberLong = jsonMemberLong;
	}
public Geolocation(){

}
	@JsonProperty("long")
	private String jsonMemberLong;
}