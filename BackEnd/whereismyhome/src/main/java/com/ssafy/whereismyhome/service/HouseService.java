package com.ssafy.whereismyhome.service;

import java.util.List;

import com.ssafy.whereismyhome.dto.HouseDealDto;
import com.ssafy.whereismyhome.dto.HouseInfoDto;
import com.ssafy.whereismyhome.dto.HouseSearchDto;

public interface HouseService {
	List<HouseInfoDto> getHouseInfo(HouseSearchDto houseSearchDto);

	HouseInfoDto getHouseByAptCode(String aptCode);

	List<HouseDealDto> getDealInfoList(String aptCode);

	Integer likeHouse(String aptCode, String userId);

	Integer likeHouseCancel(String aptCode, String userId);

	Integer getHouseLikeNumber(String aptCode);
}
