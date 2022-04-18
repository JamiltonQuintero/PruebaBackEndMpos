package com.mpos.to;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UserPutTO {
	
	@JsonProperty("fullName")
    private String fullName;
	
	@JsonProperty("username")
    private String username;
	
	@JsonProperty("email")
    private String email;

}
