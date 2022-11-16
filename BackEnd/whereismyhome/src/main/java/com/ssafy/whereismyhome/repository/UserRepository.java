package com.ssafy.whereismyhome.repository;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.whereismyhome.dto.UserDto;

@Mapper
public interface UserRepository {

	List<UserDto> selectUsers();

	UserDto selectUser(String userId);

	int insertUser(UserDto user);

	int updateUser(UserDto user);

	int deleteUser(String userId);

	String login(HashMap<String, String> map);

}
