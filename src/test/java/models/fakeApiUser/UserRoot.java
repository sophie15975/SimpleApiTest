package models.fakeApiUser;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
public class UserRoot{

	//@JsonProperty("password")
	private String password;

	@JsonProperty("address")
	private Address address;

	@JsonProperty("phone")
	private String phone;



	@JsonProperty("__v")
	private int v;

	@Getter
	@JsonProperty("name")
	private Name name;

	@JsonProperty("id")
	private int id;

	@JsonProperty("email")
	private String email;

	@JsonProperty("username")
	private String username;
	public UserRoot(String email, String username , String password,  Name name,  Address address,  String phone,int v, int id  ) {
		this.password = password;
		this.address = address;
		this.phone = phone;
		this.name = name;
		this.email = email;
		this.username = username;
		this.v = v;
		this.id = id;
	}
public  UserRoot(){}
	//public String getPassword() {
//		return password;
//	}

	public void setPassword(String password) {
		this.password = password;
	}

//	public int getId() {
//		return id;
//	}
//
	public void setId(int id) {
		this.id = id;
	}

}