package com.ssafy.whereismyhome.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ssafy.whereismyhome.dto.UserDto;
import com.ssafy.whereismyhome.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	private UserRepository userRepository;
	
//	@Autowired // 생성자 하나일 때 생략가능
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<UserDto> getUsers() {
		return userRepository.selectUsers();
	}

	@Override
	public UserDto getUser(String userId) {
		return userRepository.selectUser(userId);
	}

	@Override
	public boolean registerUser(UserDto user) {
		return userRepository.insertUser(user) > 0;
	}

	@Override
	public boolean modifyUser(UserDto user) {
		return userRepository.updateUser(user) > 0;
	}

	@Override
	public boolean deleteUser(String userId) {
		return userRepository.deleteUser(userId) > 0;
	}

	@Override
	public String login(HashMap<String, String> map) {
		return userRepository.login(map);
	}
	
	
	
}
