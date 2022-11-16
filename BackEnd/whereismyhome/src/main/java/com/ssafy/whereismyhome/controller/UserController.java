package com.ssafy.whereismyhome.controller;

import java.net.URI;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.whereismyhome.dto.UserDto;
import com.ssafy.whereismyhome.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {	
	
	private final UserService userService;
//
////	@Autowired // 생성자 하나일 땐 Autowired 생략 가능
//	public UserController(UserService userService) {
//		this.userService = userService;
//	}
	
	@GetMapping
	protected ResponseEntity<List<UserDto>> getUserList(){
		return ResponseEntity.ok(userService.getUsers());
	}
	
	@GetMapping("/{userId}")
	protected ResponseEntity<?> getUser(@PathVariable String userId) {
		UserDto user = userService.getUser(userId);
		System.out.println(userId);
		if(user != null) {
			return ResponseEntity.ok(user);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	protected ResponseEntity<?> register(@RequestBody UserDto user){
		boolean res = userService.registerUser(user);
		
		if(res) {
			return ResponseEntity.created(URI.create("/users/" + user.getUserId())).build();
		}else {
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@PutMapping("/{userId}")
	protected ResponseEntity<?> modify(@RequestBody UserDto user){
		UserDto user2 = userService.getUser(user.getUserId());
		if(user2 != null) {
			boolean res = userService.modifyUser(user);
			if(res) {
				return ResponseEntity.ok().body(user);
			}else {
				return ResponseEntity.internalServerError().build();
			}
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{userId}")
	protected ResponseEntity<?> remove(@PathVariable String userId){
		UserDto user2 = userService.getUser(userId);
		if(user2 != null) {
			boolean res = userService.deleteUser(userId);
			if(res) {
				return ResponseEntity.noContent().build();
			}else {
				return ResponseEntity.internalServerError().build();
			}
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/login")
	protected ResponseEntity<?> login(@RequestParam String userId,@RequestParam String password, HttpSession session){
		HashMap<String, String> map = new HashMap<>();
		if(userId != null) map.put("userId", userId);
		if(password != null) map.put("password", password);
		String userName = userService.login(map);
		if(userName != null) {
			session.setAttribute("userId", userId);
			session.setAttribute("userName", userName);
			return ResponseEntity.ok().body(userName);
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/logout")
	protected ResponseEntity<Object> logout(HttpSession session){
		session.invalidate();
		return ResponseEntity.notFound().build();
	}
	
}
