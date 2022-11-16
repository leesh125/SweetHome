package com.ssafy.whereismyhome.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDto {
	@NonNull
	private String userId;
	private String userName;
	private String email;
	@NonNull
	private String password;
	private String phoneNumber;
}
