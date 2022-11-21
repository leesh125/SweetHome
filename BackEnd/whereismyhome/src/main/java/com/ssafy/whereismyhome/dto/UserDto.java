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
	private String name;
	@NonNull
	private String password;
	private String phoneNumber;
	private boolean isAdmin;
}
