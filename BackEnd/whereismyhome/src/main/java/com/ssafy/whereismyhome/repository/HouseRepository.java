package com.ssafy.whereismyhome.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.whereismyhome.dto.HouseDealDto;
import com.ssafy.whereismyhome.dto.HouseInfoDto;
import com.ssafy.whereismyhome.dto.HouseSearchDto;

@Mapper
public interface HouseRepository {
	List<HouseInfoDto> selectHouseInfo(HouseSearchDto houseSearchDto);

	HouseInfoDto selectHouseInfoByAptCode(String aptCode);

	List<HouseDealDto> selectHouseDealInfo(String aptCode);
}
