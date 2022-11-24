package com.ssafy.whereismyhome.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.whereismyhome.dto.HouseDealDto;
import com.ssafy.whereismyhome.dto.HouseInfoDto;
import com.ssafy.whereismyhome.dto.HouseSearchDto;
import com.ssafy.whereismyhome.repository.HouseRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class HouseServiceImpl implements HouseService {

	private final HouseRepository houseRepository;
	
	@Transactional
	@Override
	public List<HouseInfoDto> getHouseInfo(HouseSearchDto houseSearchDto) {
		return houseRepository.selectHouseInfo(houseSearchDto);
	}

	@Transactional
	@Override
	public HouseInfoDto getHouseByAptCode(String aptCode) {
		return houseRepository.selectHouseInfoByAptCode(aptCode);
	}

	@Transactional
	@Override
	public List<HouseDealDto> getDealInfoList(String aptCode) {
		return houseRepository.selectHouseDealInfo(aptCode);
	}

	@Transactional
	@Override
	public Integer likeHouse(String aptCode, String userId) {
		Map<String,String> map = new HashMap<>();
		map.put("aptCode", aptCode);
		map.put("userId", userId);
		houseRepository.insertLike(map);
		return houseRepository.getLikeNumberByAptCode(aptCode);
	}

	@Transactional
	@Override
	public Integer likeHouseCancel(String aptCode, String userId) {
		Map<String,String> map = new HashMap<>();
		map.put("aptCode", aptCode);
		map.put("userId", userId);
		houseRepository.deleteLike(map);
		return houseRepository.getLikeNumberByAptCode(aptCode);
	}

	@Override
	public Integer getHouseLikeNumber(String aptCode) {
		return houseRepository.getLikeNumberByAptCode(aptCode);
	}
}
