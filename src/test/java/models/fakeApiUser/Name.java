package models.fakeApiUser;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@NoArgsConstructor
//@Builder

public class Name{

	public Name(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}
public Name(){}
	@JsonProperty("firstname")
	private String firstname;

	@JsonProperty("lastname")
	private String lastname;
}