package com.ssafy.whereismyhome.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ssafy.whereismyhome.dto.HouseDealDto;
import com.ssafy.whereismyhome.dto.HouseInfoDto;
import com.ssafy.whereismyhome.dto.HouseSearchDto;
import com.ssafy.whereismyhome.repository.HouseRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class HouseServiceImpl implements HouseService {

	private final HouseRepository houseRepository;
	
	@Override
	public List<HouseInfoDto> getHouseInfo(HouseSearchDto houseSearchDto) {
		return houseRepository.selectHouseInfo(houseSearchDto);
	}

	@Override
	public HouseInfoDto getHouseByAptCode(String aptCode) {
		return houseRepository.selectHouseInfoByAptCode(aptCode);
	}

	@Override
	public List<HouseDealDto> getDealInfoList(String aptCode) {
		return houseRepository.selectHouseDealInfo(aptCode);
	}

	@Override
	public Integer likeHouse(String aptCode, String userId) {
		return houseRepository.insertLike(aptCode, userId);
	}

	@Override
	public Integer likeHouseCancel(String aptCode, String userId) {
		// TODO Auto-generated method stub
		return houseRepository.deleteLike(aptCode, userId);
	}


}
