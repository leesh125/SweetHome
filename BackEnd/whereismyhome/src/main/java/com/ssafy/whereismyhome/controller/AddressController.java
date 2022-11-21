package com.ssafy.whereismyhome.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.whereismyhome.dto.DongDto;
import com.ssafy.whereismyhome.dto.GugunDto;
import com.ssafy.whereismyhome.dto.LatLngDto;
import com.ssafy.whereismyhome.dto.SidoDto;
import com.ssafy.whereismyhome.service.AddressService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/address")
@RestController
@RequiredArgsConstructor
public class AddressController {

	private final AddressService addressService;

	@GetMapping
	public ResponseEntity<Object> getSidoList() {
		List<SidoDto> sidos = addressService.getSidoList();		
		if(sidos != null) {
			return ResponseEntity.ok(sidos);
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	@GetMapping("/{sidocode}")
	public ResponseEntity<Object> getGugunList(@PathVariable("sidocode") String sidoCode) {
		List<GugunDto> guguns = addressService.getGugunList(sidoCode);
		if(guguns != null) {
			return ResponseEntity.ok(guguns);
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	@GetMapping("/{sidocode}/{guguncode}")
	public ResponseEntity<Object> getDongList(@PathVariable("sidocode") String sidoCode, @PathVariable("guguncode") String gugunCode) {
		List<DongDto> dongs = addressService.getDongList(sidoCode, gugunCode);
		if(dongs != null) {
			return ResponseEntity.ok(dongs);
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@GetMapping("/latlng/{dongCode}")
	public ResponseEntity<Object> getLatLng(@PathVariable String dongCode){
		LatLngDto latLng = addressService.getLatLng(dongCode);
		if(latLng != null) {
			return ResponseEntity.ok(latLng);
		}
		else {
			return ResponseEntity.noContent().build();
		}
	}
}
