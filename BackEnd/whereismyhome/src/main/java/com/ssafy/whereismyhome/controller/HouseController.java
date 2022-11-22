package com.ssafy.whereismyhome.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.whereismyhome.dto.HouseDealDto;
import com.ssafy.whereismyhome.dto.HouseInfoDto;
import com.ssafy.whereismyhome.dto.HouseSearchDto;
import com.ssafy.whereismyhome.service.HouseService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/houses")
@RestController
public class HouseController {
	
	private final HouseService houseService;
	
	//지역 코드별, 순서별 아파트 정보 리스트
	@GetMapping
	public ResponseEntity<?> getHouseInfoList(@RequestParam(required = false) String locationCode,
			@RequestParam(required = false) String searchWord,
			@RequestParam(required = false) Integer searchOrder) {
			List<HouseInfoDto> houseInfoList = null;
			
		houseInfoList = houseService.getHouseInfo(new HouseSearchDto(locationCode, searchWord, searchOrder));
		
		if(!houseInfoList.isEmpty()) {			
			log.info("asdf" + houseInfoList.get(0).getBaseAddressDto());
			return ResponseEntity.ok(houseInfoList);
		}else {
			return ResponseEntity.noContent().build();
		}
	}
	
	//아파트 정보
	@GetMapping("/{aptCode}")
	public ResponseEntity<?> getHouseInfo(@PathVariable String aptCode) {
		HouseInfoDto houseInfo = houseService.getHouseByAptCode(aptCode);
		
		if(houseInfo != null) {			
			return ResponseEntity.ok(houseInfo);
		}else {
			return ResponseEntity.noContent().build();
		}
	}
	
	//아파트별 매매정보
	@GetMapping("/{aptCode}/dealInfos")
	public ResponseEntity<?> getHouseDealInfo(@PathVariable String aptCode) {
		 List<HouseDealDto> houseDealList = houseService.getDealInfoList(aptCode);
		
		if(!houseDealList.isEmpty()) {			
			return ResponseEntity.ok(houseDealList);
		}else {
			return ResponseEntity.noContent().build();
		}
	}
}
