package com.ssafy.whereismyhome.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.whereismyhome.dto.DongDto;
import com.ssafy.whereismyhome.dto.GugunDto;
import com.ssafy.whereismyhome.dto.SidoDto;

@Mapper
public interface AddressRepository {

	List<SidoDto> selectSido();

	List<GugunDto> selectGugun(String sidoCode);

	List<DongDto> selectDong(String sidoGugunCode);
}
