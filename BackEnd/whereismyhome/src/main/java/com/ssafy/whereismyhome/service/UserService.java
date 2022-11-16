package com.ssafy.whereismyhome.service;

import java.util.HashMap;
import java.util.List;

import com.ssafy.whereismyhome.dto.UserDto;

public interface UserService {

	List<UserDto> getUsers();

	UserDto getUser(String userId);

	boolean registerUser(UserDto user);

	boolean modifyUser(UserDto user);

	String login(HashMap<String, String> map);

	boolean deleteUser(String userId);

}
